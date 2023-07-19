package com.TheRealDoomSlayer69.littleadditions.entity.abstratc;

import com.TheRealDoomSlayer69.littleadditions.entity.LAEntities;
import com.TheRealDoomSlayer69.littleadditions.entity.pigman.trades.PigmanTrades;
import com.TheRealDoomSlayer69.littleadditions.entity.zombie_pigman.ZombiePigmanEntity;
import com.google.common.collect.Sets;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.npc.InventoryCarrier;
import net.minecraft.world.entity.npc.Npc;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.Merchant;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

import javax.annotation.Nullable;
import java.util.Set;

public abstract class AbstractPigman extends AgeableMob implements InventoryCarrier, Npc, Merchant {
    public static final int PIGMAN_SLOT_OFFSET = 300;
    private static final int PIGMAN_INVENTORY_SIZE = 8;
    @Nullable
    private Player tradingPlayer;
    @Nullable
    protected MerchantOffers offers;
    private final SimpleContainer inventory = new SimpleContainer(8);

    public int timeInNether;

    public AbstractPigman(EntityType<? extends AbstractPigman>pEntityType, Level pLevel){
        super(pEntityType, pLevel);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, 16.0F);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_FIRE, -1.0F);
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        if (pSpawnData == null) {
            pSpawnData = new AgeableMob.AgeableMobGroupData(false);
        }

        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }

    public int getVillagerXp() {
        return 0;
    }

    public float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
        return this.isBaby() ? 0.81F : 0.9F;
    }

    public void setTradingPlayer(@Nullable Player pPlayer) {
        this.tradingPlayer = pPlayer;
    }

    @Nullable
    public Player getTradingPlayer() {
        return this.tradingPlayer;
    }

    public boolean isTrading() {
        return this.tradingPlayer != null;
    }

    public MerchantOffers getOffers() {
        if (this.offers == null) {
            this.offers = new MerchantOffers();
            this.updateTrades();
        }

        return this.offers;
    }

    public void overrideOffers(@Nullable MerchantOffers pOffers) {
    }

    public void overrideXp(int pXp) {
    }

    public void notifyTrade(MerchantOffer pOffer) {
        pOffer.increaseUses();
        this.ambientSoundTime = -this.getAmbientSoundInterval();
        this.rewardTradeXp(pOffer);

    }

    protected abstract void rewardTradeXp(MerchantOffer pOffer);

    public boolean showProgressBar() {
        return true;
    }

    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        MerchantOffers merchantoffers = this.getOffers();
        if (!merchantoffers.isEmpty()) {
            pCompound.put("Offers", merchantoffers.createTag());
        }
        pCompound.putInt("TimeInNether", this.timeInNether);

        pCompound.put("Inventory", this.inventory.createTag());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        if (pCompound.contains("Offers", 10)) {
            this.offers = new MerchantOffers(pCompound.getCompound("Offers"));
        }
        this.timeInNether = pCompound.getInt("TimeInNether");
        this.inventory.fromTag(pCompound.getList("Inventory", 10));
    }

    @Nullable
    public Entity changeDimension(ServerLevel pServer, net.minecraftforge.common.util.ITeleporter teleporter) {
        this.stopTrading();
        return super.changeDimension(pServer, teleporter);
    }

    protected void stopTrading() {
        this.setTradingPlayer((Player)null);
    }

    public void die(DamageSource pCause) {
        super.die(pCause);
        this.stopTrading();
    }

    public boolean canBeLeashed(Player pPlayer) {
        return false;
    }

    public SimpleContainer getInventory() {
        return this.inventory;
    }

    public SlotAccess getSlot(int pSlot) {
        int i = pSlot - 300;
        return i >= 0 && i < this.inventory.getContainerSize() ? SlotAccess.forContainer(this.inventory, i) : super.getSlot(pSlot);
    }

    protected abstract void updateTrades();

    protected void addOffersFromItemListings(MerchantOffers pGivenMerchantOffers, PigmanTrades.ItemListing[] pNewTrades, int pMaxNumbers) {
        Set<Integer> set = Sets.newHashSet();
        if (pNewTrades.length > pMaxNumbers) {
            while(set.size() < pMaxNumbers) {
                set.add(this.random.nextInt(pNewTrades.length));
            }
        } else {
            for(int i = 0; i < pNewTrades.length; ++i) {
                set.add(i);
            }
        }

        for(Integer integer : set) {
            PigmanTrades.ItemListing pigmantrades$itemlisting = pNewTrades[integer];
            MerchantOffer merchantoffer = pigmantrades$itemlisting.getOffer(this, this.random);
            if (merchantoffer != null) {
                pGivenMerchantOffers.add(merchantoffer);
            }
        }

    }

    public void notifyTradeUpdated(ItemStack pStack) {
        if (!this.level.isClientSide && this.ambientSoundTime > -this.getAmbientSoundInterval() + 20) {
            this.ambientSoundTime = -this.getAmbientSoundInterval();
            this.playSound(this.getTradeUpdatedSound(!pStack.isEmpty()), this.getSoundVolume(), this.getVoicePitch());
        }

    }

    public SoundEvent getNotifyTradeSound() {
        return SoundEvents.VILLAGER_YES;
    }

    protected SoundEvent getTradeUpdatedSound(boolean pIsYesSound) {
        return pIsYesSound ? SoundEvents.VILLAGER_YES : SoundEvents.VILLAGER_NO;
    }

    public void playCelebrateSound() {
        this.playSound(SoundEvents.VILLAGER_CELEBRATE, this.getSoundVolume(), this.getVoicePitch());
    }

    public boolean isConverting() {
        return !this.level.dimensionType().hasSkyLight()  && !this.isNoAi();
    }


    protected void customServerAiStep() {
        super.customServerAiStep();
        if (this.isConverting()) {
            ++this.timeInNether;
        } else {
            this.timeInNether = 0;
            this.timeInNether = 0;
        }

        if (this.timeInNether > 200 && net.minecraftforge.event.ForgeEventFactory.canLivingConvert(this, LAEntities.ZOMBIE_PIGMAN.get(), (timer) -> this.timeInNether = timer)) {
            this.finishConversion((ServerLevel)this.level);
        }

    }

    public void finishConversion(ServerLevel pServerLevel) {
        ZombiePigmanEntity zombiePigman = this.convertTo(LAEntities.ZOMBIE_PIGMAN.get(), true);
        if (zombiePigman != null) {
            zombiePigman.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0));
            net.minecraftforge.event.ForgeEventFactory.onLivingConvert(this, zombiePigman);
        }

    }
}
