package com.TheRealDoomSlayer69.littleadditions.entity.human;


import com.TheRealDoomSlayer69.littleadditions.entity.pigman.PigmanEntity;
import com.TheRealDoomSlayer69.littleadditions.item.LAItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ToolActions;


import javax.annotation.Nullable;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.UUID;

public class HumanEntity extends Monster implements NeutralMob {

public HumanEntity(EntityType<? extends Monster> entityType, Level level) {
    super(entityType, level);
    ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(true);

}
    private final MeleeAttackGoal meleeGoal = new MeleeAttackGoal(this, 1.2D, false) {
        public void stop() {
            super.stop();
            HumanEntity.this.setAggressive(false);
        }

        public void start() {
            super.start();
            HumanEntity.this.setAggressive(true);
        }
    };


    public static AttributeSupplier setAttributes() {
        return HumanEntity.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 2.0f)
                .add(Attributes.ATTACK_SPEED, 1.2f)
                .add(Attributes.MOVEMENT_SPEED, 0.3f).build();

    }



    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
       this.goalSelector.addGoal(2, new OpenDoorGoal(this, true));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(6, (new HurtByTargetGoal(this)).setAlertOthers());
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, .6D));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.2, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, PigmanEntity.class, true));
    }

    protected void populateDefaultEquipmentSlots(DifficultyInstance difficultyInstance) {
        super.populateDefaultEquipmentSlots(difficultyInstance);
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
        this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD));
        this.maybeWearArmor(EquipmentSlot.HEAD, this.createSpawnHelmet());
        this.maybeWearArmor(EquipmentSlot.CHEST, this.createSpawnChestplate());
        this.maybeWearArmor(EquipmentSlot.LEGS, this.createSpawnLeggings());
        this.maybeWearArmor(EquipmentSlot.FEET, this.createSpawnBoots());
    }

    private void maybeWearArmor(EquipmentSlot pSlot, ItemStack pStack) {
        if (this.level.random.nextFloat() < 0.1F) {
            this.setItemSlot(pSlot, pStack);
        }

    }


    private ItemStack createSpawnHelmet() {
        return (double)this.random.nextFloat() < 0.6D ? new ItemStack(Items.IRON_HELMET) : new ItemStack(Items.DIAMOND_HELMET);
    }

    private ItemStack createSpawnChestplate() {
        return (double)this.random.nextFloat() < 0.6D ? new ItemStack(Items.IRON_CHESTPLATE) : new ItemStack(Items.DIAMOND_CHESTPLATE);
    }

    private ItemStack createSpawnLeggings() {
        return (double)this.random.nextFloat() < 0.6D ? new ItemStack(Items.IRON_LEGGINGS) : new ItemStack(Items.DIAMOND_LEGGINGS);
    }

    private ItemStack createSpawnBoots() {
        return (double)this.random.nextFloat() < 0.6D ? new ItemStack(Items.IRON_BOOTS) : new ItemStack(Items.DIAMOND_BOOTS);
    }





    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
                                        MobSpawnType spawnType, @Nullable SpawnGroupData groupData, @Nullable CompoundTag compoundTag) {
        groupData = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, groupData, compoundTag);


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

    public boolean isBlocking() {
        return this.getOffhandItem().canPerformAction(ToolActions.SHIELD_BLOCK);
    }


    public void reassessWeaponGoal() {
        if (!this.level.isClientSide) {
            this.goalSelector.removeGoal(this.meleeGoal);
            this.goalSelector.addGoal(4, this.meleeGoal);
        }
    }
    public void setItemSlot(EquipmentSlot p_32138_, ItemStack p_32139_) {
        super.setItemSlot(p_32138_, p_32139_);
        if (!this.level.isClientSide) {
            this.reassessWeaponGoal();
        }
    }

    protected float getStandingEyeHeight(Pose p_32154_, EntityDimensions p_32155_) {
        return 1.74F;
    }





    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        if (damageSourceIn == DamageSource.ON_FIRE) {
            return SoundEvents.PLAYER_HURT_ON_FIRE;
        } else if (damageSourceIn == DamageSource.DROWN) {
            return SoundEvents.PLAYER_HURT_DROWN;
        } else if (damageSourceIn == DamageSource.SWEET_BERRY_BUSH) {
            return SoundEvents.PLAYER_HURT_SWEET_BERRY_BUSH;
        } else {
            return damageSourceIn == DamageSource.FREEZE ? SoundEvents.PLAYER_HURT_FREEZE : SoundEvents.PLAYER_HURT;
        }
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.PLAYER_DEATH;
    }

    protected float getSoundVolume() {
        return 0.2F;
    }

    @Override
    public int getRemainingPersistentAngerTime() {
        return 5;
    }

    @Override
    public void setRemainingPersistentAngerTime(int pRemainingPersistentAngerTime) {

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
