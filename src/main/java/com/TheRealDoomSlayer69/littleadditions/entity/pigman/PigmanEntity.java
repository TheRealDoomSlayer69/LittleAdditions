package com.TheRealDoomSlayer69.littleadditions.entity.pigman;

import com.TheRealDoomSlayer69.littleadditions.entity.abstratc.AbstractPigman;
import com.TheRealDoomSlayer69.littleadditions.entity.goal.LookAtPigmanTradingPLayerGoal;
import com.TheRealDoomSlayer69.littleadditions.entity.goal.PigmanTradeWithPlayerGoal;
import com.TheRealDoomSlayer69.littleadditions.entity.pigman.trades.PigmanTrades;
import com.TheRealDoomSlayer69.littleadditions.entity.zombie_pigman.ZombiePigmanEntity;
import com.TheRealDoomSlayer69.littleadditions.item.LAItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;



import javax.annotation.Nullable;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.*;


public class PigmanEntity extends AbstractPigman implements NeutralMob, RangedAttackMob {
    private static final EntityDataAccessor<Boolean> DATA_BABY_ID = SynchedEntityData.defineId(PigmanEntity.class, EntityDataSerializers.BOOLEAN);
    private static final UUID SPEED_MODIFIER_BABY_UUID = UUID.fromString("766bfa64-11f3-11ea-8d71-362b9e155667");
    private static final AttributeModifier SPEED_MODIFIER_BABY = new AttributeModifier(SPEED_MODIFIER_BABY_UUID, "Baby speed boost", (double)0.2F, AttributeModifier.Operation.MULTIPLY_BASE);

    private int remainingPersistentAngerTime;



public PigmanEntity(EntityType<? extends PigmanEntity> entityType, Level level) {
    super(entityType, level);
    this.setCanPickUpLoot(true);
    ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(true);

    }

    public static boolean checkPimanSpawnRules(EntityType<PigmanEntity> pPigman, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, Random pRandom) {
        return !pLevel.getBlockState(pPos.below()).is(Blocks.GRASS_BLOCK);
    }


    @Nullable
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }




    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        if (this.isBaby()) {
            pCompound.putBoolean("IsBaby", true);
        }
    }





    private final RangedBowAttackGoal<PigmanEntity> bowAttackGoal = new RangedBowAttackGoal<>(this, 1.0D, 20, 15.0F);
    private final MeleeAttackGoal meleeGoal = new MeleeAttackGoal(this, 1.2D, false) {
        public void stop() {
            super.stop();
            PigmanEntity.this.setAggressive(false);
        }

        public void start() {
            super.start();
            PigmanEntity.this.setAggressive(true);
        }
    };

    public static AttributeSupplier setAttributes() {
    return PigmanEntity.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 20.0D)
            .add(Attributes.ATTACK_DAMAGE, 3.0f)
            .add(Attributes.ATTACK_SPEED, 1.2f)
            .add(Attributes.MOVEMENT_SPEED, 0.3f).build();


    }

    public void rewardTradeXp(MerchantOffer pOffer) {
        if (pOffer.shouldRewardExp()) {
            int i = 3 + this.random.nextInt(4);
            this.level.addFreshEntity(new ExperienceOrb(this.level, this.getX(), this.getY() + 0.6D, this.getZ(), i));
        }

    }





    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PigmanTradeWithPlayerGoal(this));
        this.goalSelector.addGoal(1, new LookAtPigmanTradingPLayerGoal(this));
        this.goalSelector.addGoal(2, new AvoidEntityGoal<ZombiePigmanEntity>(this, ZombiePigmanEntity.class, 6.5f, 1d, 0.9d));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Piglin.class, true));
        this.targetSelector.addGoal(3, new OpenDoorGoal(this, true));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.2, false));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.targetSelector.addGoal(6, (new HurtByTargetGoal(this)).setAlertOthers());
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, .6D));
        this.goalSelector.addGoal(8, new InteractGoal(this, Player.class, 3.0F, 1.0F));
    }

    protected void populateDefaultEquipmentSlots(DifficultyInstance difficultyInstance) {
        super.populateDefaultEquipmentSlots(difficultyInstance);
        this.setItemSlot(EquipmentSlot.MAINHAND, this.createSpawnWeapon());
        this.maybeWearArmor(EquipmentSlot.HEAD, new ItemStack(LAItems.RUBY_HELMET.get()));
        this.maybeWearArmor(EquipmentSlot.CHEST, new ItemStack(LAItems.RUBY_CHESTPLATE.get()));
        this.maybeWearArmor(EquipmentSlot.LEGS, new ItemStack(LAItems.RUBY_LEGGINGS.get()));
        this.maybeWearArmor(EquipmentSlot.FEET, new ItemStack(LAItems.RUBY_BOOTS.get()));
    }

    private void maybeWearArmor(EquipmentSlot pSlot, ItemStack pStack) {
        if (this.level.random.nextFloat() < 0.1F) {
            this.setItemSlot(pSlot, pStack);
        }

    }

    public boolean showProgressBar() {
        return false;
    }

    @Override
    public boolean isClientSide() {
        return false;
    }

    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (!itemstack.is(Items.VILLAGER_SPAWN_EGG) && this.isAlive() && !this.isTrading() && !this.isBaby()) {
            if (pHand == InteractionHand.MAIN_HAND) {
                pPlayer.awardStat(Stats.TALKED_TO_VILLAGER);
            }

            if (!this.level.isClientSide) {
                this.setTradingPlayer(pPlayer);
                this.openTradingScreen(pPlayer, this.getDisplayName(), 1);
            }

            return InteractionResult.sidedSuccess(this.level.isClientSide);
        } else {
            if (this.getOffers().isEmpty()) {
                return InteractionResult.sidedSuccess(this.level.isClientSide);
            } else {
                return super.mobInteract(pPlayer, pHand);
            }
        }
    }



    protected void updateTrades() {
        MerchantOffers merchantoffers = this.getOffers();

        for (int level = 1; level <= 5; level++) {
            PigmanTrades.ItemListing[] listings = PigmanTrades.PIGMAN_TRADES.get(level);

            if (listings != null) {
                this.addOffersFromItemListings(merchantoffers, listings, 3);

                if (level == 1 || level == 2) {
                    int i = this.random.nextInt(listings.length);
                    PigmanTrades.ItemListing pigmantrades$itemlisting = listings[i];
                    MerchantOffer merchantoffer = pigmantrades$itemlisting.getOffer(this, this.random);

                    if (merchantoffer != null) {
                        merchantoffers.add(merchantoffer);
                    }
                }
            }
        }
    }


    private ItemStack createSpawnWeapon() {
        return (double)this.random.nextFloat() < 0.6D ? new ItemStack(LAItems.RUBY_SWORD.get()) : new ItemStack(Items.BOW);
    }

    public boolean isAdult() {
        return !this.isBaby();
    }



    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
                                        MobSpawnType spawnType, @Nullable SpawnGroupData groupData, @Nullable CompoundTag compoundTag) {
        groupData = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, groupData, compoundTag);

        if (spawnType != MobSpawnType.STRUCTURE) {
            if (levelAccessor.getRandom().nextFloat() < 0.2F) {
                this.setBaby(true);
            } else if (this.isAdult()) {
                this.setItemSlot(EquipmentSlot.MAINHAND, this.createSpawnWeapon());
            }
        }
        this.populateDefaultEquipmentSlots(difficultyInstance);
        this.populateDefaultEquipmentEnchantments(difficultyInstance);
        this.reassessWeaponGoal();
        this.setCanPickUpLoot(this.random.nextFloat() < 0.55F * difficultyInstance.getSpecialMultiplier());
        if (this.getItemBySlot(EquipmentSlot.HEAD).isEmpty()) {
            LocalDate localdate = LocalDate.now();
            int i = localdate.get(ChronoField.DAY_OF_MONTH);
            int j = localdate.get(ChronoField.MONTH_OF_YEAR);
            if (j == 10 && i == 31 && this.random.nextFloat() < 0.25F) {
                this.setItemSlot(EquipmentSlot.HEAD,
                        new ItemStack(this.random.nextFloat() < 0.1F ? Blocks.JACK_O_LANTERN : Blocks.CARVED_PUMPKIN)
                );
                this.armorDropChances[EquipmentSlot.HEAD.getIndex()] = 0.3F;
            }
        }
        return groupData;

    }

    public void setBaby(boolean pChildZombie) {
        this.getEntityData().set(DATA_BABY_ID, pChildZombie);
        if (!this.level.isClientSide) {
            AttributeInstance attributeinstance = this.getAttribute(Attributes.MOVEMENT_SPEED);
            attributeinstance.removeModifier(SPEED_MODIFIER_BABY);
            if (pChildZombie) {
                attributeinstance.addTransientModifier(SPEED_MODIFIER_BABY);
            }
        }

    }

    public void performRangedAttack(LivingEntity entity, float power) {
        ItemStack itemstack = Items.TIPPED_ARROW.getDefaultInstance();
        AbstractArrow abstractarrow = this.getArrow(itemstack, power);
        if (this.getMainHandItem().getItem() instanceof net.minecraft.world.item.BowItem)
            abstractarrow = ((net.minecraft.world.item.BowItem)this.getMainHandItem().getItem()).customArrow(abstractarrow);
        double d0 = entity.getX() - this.getX();
        double d1 = entity.getY(0.3333333333333333D) - abstractarrow.getY();
        double d2 = entity.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        abstractarrow.shoot(d0, d1 + d3 * (double)0.2F, d2, 1.6F, (float)(14 - this.level.getDifficulty().getId() * 4));
        this.playSound(SoundEvents.ARROW_SHOOT, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level.addFreshEntity(abstractarrow);
    }

    protected AbstractArrow getArrow(ItemStack stack, float power) {
        return ProjectileUtil.getMobArrow(this, stack, power);
    }

    public boolean canFireProjectileWeapon(ProjectileWeaponItem projectileWeaponItem) {
        return projectileWeaponItem == Items.BOW;
    }


    public boolean isBaby() {
        return this.getEntityData().get(DATA_BABY_ID);
    }

    public boolean startRiding(Entity pEntity, boolean pForce) {
        if (this.isBaby() && pEntity.getType() == EntityType.PIG) {
            pEntity = this.getTopPassenger(pEntity, 3);
        }

        return super.startRiding(pEntity, pForce);
    }

    private Entity getTopPassenger(Entity pVehicle, int pMaxPosition) {
        List<Entity> list = pVehicle.getPassengers();
        return pMaxPosition != 1 && !list.isEmpty() ? this.getTopPassenger(list.get(0), pMaxPosition - 1) : pVehicle;
    }

    public double getMyRidingOffset() {
        return this.isBaby() ? -0.05D : -0.45D;
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_BABY_ID, false);

    }




    public void onSyncedDataUpdated(EntityDataAccessor<?> pKey) {
        super.onSyncedDataUpdated(pKey);
        if (DATA_BABY_ID.equals(pKey)) {
            this.refreshDimensions();
        }

    }






    public void reassessWeaponGoal() {
        if (!this.level.isClientSide) {
            this.goalSelector.removeGoal(this.meleeGoal);
            this.goalSelector.removeGoal(this.bowAttackGoal);

            ItemStack itemstack = this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, item -> item instanceof net.minecraft.world.item.BowItem));
            if (itemstack.is(Items.BOW)) {
                int i = 20;
                if (this.level.getDifficulty() != Difficulty.HARD) {
                    i = 40;
                }
                this.bowAttackGoal.setMinAttackInterval(i);
                this.goalSelector.addGoal(2, this.bowAttackGoal);
            } else {

                this.goalSelector.addGoal(4, this.meleeGoal);
            }
        }
    }


    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.reassessWeaponGoal();
        this.setBaby(tag.getBoolean("IsBaby"));
    }

    public void setItemSlot(EquipmentSlot p_32138_, ItemStack p_32139_) {
        super.setItemSlot(p_32138_, p_32139_);
        if (!this.level.isClientSide) {
            this.reassessWeaponGoal();
        }
    }


    public float getStandingEyeHeight(Pose p_32154_, EntityDimensions p_32155_) {
        return 1.75F;
    }


    @Nullable
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.PIG_STEP, 0.15F, 1.0F);
    }


    protected SoundEvent getAmbientSound() {
        return SoundEvents.PIGLIN_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.PIGLIN_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.PIGLIN_DEATH;
    }

    protected float getSoundVolume() {
        return 0.2F;
    }

    @Override
    public int getRemainingPersistentAngerTime() {
        return this.remainingPersistentAngerTime;
    }

    @Override
    public void setRemainingPersistentAngerTime(int pTime) {
        this.remainingPersistentAngerTime = pTime;
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public UUID getPersistentAngerTarget() {
        return null;
    }

    @Override
    public void setPersistentAngerTarget(@org.jetbrains.annotations.Nullable UUID pPersistentAngerTarget) {

    }

    @Override
    public void startPersistentAngerTimer() {

    }


}



