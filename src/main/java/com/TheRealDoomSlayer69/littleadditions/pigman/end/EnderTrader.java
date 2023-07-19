package com.TheRealDoomSlayer69.littleadditions.entity.pigman.end;

import com.TheRealDoomSlayer69.littleadditions.entity.abstratc.AbstractPigman;
import com.TheRealDoomSlayer69.littleadditions.entity.goal.LookAtPigmanTradingPLayerGoal;
import com.TheRealDoomSlayer69.littleadditions.entity.goal.PigmanTradeWithPlayerGoal;
import com.TheRealDoomSlayer69.littleadditions.entity.pigman.trades.PigmanTrades;
import com.TheRealDoomSlayer69.littleadditions.entity.zombie_pigman.ZombiePigmanEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.UUID;

public class EnderTrader extends AbstractPigman implements NeutralMob {

    private int remainingPersistentAngerTime;

    public EnderTrader(EntityType<? extends EnderTrader> entityType, Level level) {
        super(entityType, level);
        this.setCanPickUpLoot(true);
        ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(true);

    }

    public static AttributeSupplier setAttributes() {
        return EnderTrader.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 2.0f)
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
        this.targetSelector.addGoal(3, new OpenDoorGoal(this, true));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.2, false));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.targetSelector.addGoal(6, (new HurtByTargetGoal(this)).setAlertOthers());
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, .6D));
        this.goalSelector.addGoal(8, new InteractGoal(this, Player.class, 3.0F, 1.0F));
    }

    @Nullable
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
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
            PigmanTrades.ItemListing[] listings = PigmanTrades.ENDER_TRADER.get(level);

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

    protected boolean teleport() {
        if (!this.level.isClientSide() && this.isAlive()) {
            double d0 = this.getX() + (this.random.nextDouble() - 0.5D) * 64.0D;
            double d1 = this.getY() + (double)(this.random.nextInt(64) - 32);
            double d2 = this.getZ() + (this.random.nextDouble() - 0.5D) * 64.0D;
            return this.teleport(d0, d1, d2);
        } else {
            return false;
        }
    }

    boolean teleportTowards(Entity pTarget) {
        Vec3 vec3 = new Vec3(this.getX() - pTarget.getX(), this.getY(0.5D) - pTarget.getEyeY(), this.getZ() - pTarget.getZ());
        vec3 = vec3.normalize();
        double d0 = 16.0D;
        double d1 = this.getX() + (this.random.nextDouble() - 0.5D) * 8.0D - vec3.x * 16.0D;
        double d2 = this.getY() + (double)(this.random.nextInt(16) - 8) - vec3.y * 16.0D;
        double d3 = this.getZ() + (this.random.nextDouble() - 0.5D) * 8.0D - vec3.z * 16.0D;
        return this.teleport(d1, d2, d3);
    }

    private boolean teleport(double pX, double pY, double pZ) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(pX, pY, pZ);

        while(blockpos$mutableblockpos.getY() > this.level.getMinBuildHeight() && !this.level.getBlockState(blockpos$mutableblockpos).getMaterial().blocksMotion()) {
            blockpos$mutableblockpos.move(Direction.DOWN);
        }

        BlockState blockstate = this.level.getBlockState(blockpos$mutableblockpos);
        boolean flag = blockstate.getMaterial().blocksMotion();
        boolean flag1 = blockstate.getFluidState().is(FluidTags.WATER);
        if (flag && !flag1) {
            net.minecraftforge.event.entity.EntityTeleportEvent.EnderEntity event = net.minecraftforge.event.ForgeEventFactory.onEnderTeleport(this, pX, pY, pZ);
            if (event.isCanceled()) return false;
            boolean flag2 = this.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
            if (flag2 && !this.isSilent()) {
                this.level.playSound((Player)null, this.xo, this.yo, this.zo, SoundEvents.ENDERMAN_TELEPORT, this.getSoundSource(), 1.0F, 1.0F);
                this.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.0F);
            }

            return flag2;
        } else {
            return false;
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
