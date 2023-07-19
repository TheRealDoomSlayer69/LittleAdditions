package com.TheRealDoomSlayer69.littleadditions.entity.pigman.trades;

import com.TheRealDoomSlayer69.littleadditions.item.LAItems;
import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;


import javax.annotation.Nullable;
import java.util.Random;

public class PigmanTrades {


    public static final Int2ObjectMap<PigmanTrades.ItemListing[]> PIGMAN_TRADES =
            toIntMap(ImmutableMap.of(1,  new PigmanTrades.ItemListing[]
                    {new PigmanTrades.ItemsForRubies(Items.GOLDEN_APPLE, 2, 3, 4),
                            new PigmanTrades.ItemsForRubies(Items.EMERALD, 1,3, 6),
                            new PigmanTrades.ItemsForRubies(Items.BREAD, 1,4, 6),
                            new PigmanTrades.RubiesForItems(Items.IRON_INGOT, 3 , 5, 8),
                            new PigmanTrades.ItemsForRubies(Items.BAKED_POTATO, 2, 5, 6),
                            new PigmanTrades.ItemsForRubies(Items.GOLDEN_CHESTPLATE, 3, 1, 10)}));

    public static final Int2ObjectMap<PigmanTrades.ItemListing[]> ENDER_TRADER =
            toIntMap(ImmutableMap.of(1,  new PigmanTrades.ItemListing[]
                    {new PigmanTrades.ItemsForRubies(Items.ENDER_PEARL, 2, 2, 5),
                            new PigmanTrades.ItemsForRubies(Items.CHORUS_FRUIT, 3,4, 6),
                            new PigmanTrades.ItemsAndRubiesToItems(Items.ENDER_PEARL, 2, Items.ENDER_EYE,  2,4, 6)}));




    private static Int2ObjectMap<PigmanTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, PigmanTrades.ItemListing[]> pMap) {
        return new Int2ObjectOpenHashMap<>(pMap);
    }
    static class RubiesForItems implements PigmanTrades.ItemListing {
        private final Item item;
        private final int cost;
        private final int maxUses;
        private final int pigmanXp;
        private final float priceMultiplier;

        public RubiesForItems(ItemLike pItem, int pCost, int pMaxUses, int pPigmanXp) {
            this.item = pItem.asItem();
            this.cost = pCost;
            this.maxUses = pMaxUses;
            this.pigmanXp = pPigmanXp;
            this.priceMultiplier = 0.05F;
        }

        public MerchantOffer getOffer(Entity pTrader, Random pRand) {
            ItemStack itemstack = new ItemStack(this.item, this.cost);
            return new MerchantOffer(itemstack, new ItemStack(LAItems.RUBY.get()), this.maxUses, this.pigmanXp, this.priceMultiplier);
        }

    }



    static class ItemsAndRubiesToItems implements PigmanTrades.ItemListing {

        private final ItemStack fromItem;
        private final int fromCount;
        private final int rubyCost;
        private final ItemStack toItem;
        private final int toCount;
        private final int maxUses;
        private final int pigmanXp;
        private final float priceMultiplier;

        public ItemsAndRubiesToItems(ItemLike pFromItem, int pFromCount, Item pToItem, int pToCount, int pMaxUses, int pPigmanXp) {
            this(pFromItem, pFromCount, 1, pToItem, pToCount, pMaxUses, pPigmanXp);
        }

        public ItemsAndRubiesToItems(ItemLike pFromItem, int pFromCount, int pRubyCost, Item pToItem, int pToCount, int pMaxUses, int pPigmanXp) {
            this.fromItem = new ItemStack(pFromItem);
            this.fromCount = pFromCount;
            this.rubyCost = pRubyCost;
            this.toItem = new ItemStack(pToItem);
            this.toCount = pToCount;
            this.maxUses = pMaxUses;
            this.pigmanXp = pPigmanXp;
            this.priceMultiplier = 0.05F;
        }

        @Nullable
        public MerchantOffer getOffer(Entity pTrader, Random pRand) {
            return new MerchantOffer(new ItemStack(LAItems.RUBY.get(), this.rubyCost), new ItemStack(this.fromItem.getItem(), this.fromCount), new ItemStack(this.toItem.getItem(), this.toCount), this.maxUses, this.pigmanXp, this.priceMultiplier);
        }
    }

    static class ItemsForRubies implements PigmanTrades.ItemListing {
        private final ItemStack itemStack;
        private final int rubyCost;
        private final int numberOfItems;
        private final int maxUses;
        private final int pigmanXp;
        private final float priceMultiplier;

      public ItemsForRubies(Block pBlock, int pRubyCost, int pNumberOfItems, int pMaxUses, int pPigmanXp){
        this(new ItemStack(pBlock), pRubyCost, pNumberOfItems, pMaxUses, pPigmanXp);
    }

      public ItemsForRubies(Item pItem, int pRubyCost, int pNumberOfItems, int pPigmanXp){
        this(new ItemStack(pItem), pRubyCost, pNumberOfItems, 12, pPigmanXp);
    }

      public ItemsForRubies(Item pItem, int pRubyCost, int pNumberOfItems, int pMaxUses, int pPigmanXp){
        this(new ItemStack(pItem), pRubyCost, pNumberOfItems, pMaxUses, pPigmanXp);
    }

      public ItemsForRubies(ItemStack pItemStack, int pRubyCost, int pNumberOfItems, int pMaxUses, int pPigmanXp){
        this(pItemStack, pRubyCost, pNumberOfItems, pMaxUses, pPigmanXp, 0.05F);
    }

      public ItemsForRubies(ItemStack pItemStack, int pRubyCost, int pNumberOfItems, int pMaxUses, int pPigmanXp,
        float pPriceMultiplier){
        this.itemStack = pItemStack;
        this.rubyCost = pRubyCost;
        this.numberOfItems = pNumberOfItems;
        this.maxUses = pMaxUses;
        this.pigmanXp = pPigmanXp;
        this.priceMultiplier = pPriceMultiplier;
    }

        public MerchantOffer getOffer (Entity pTrader, Random pRand){
        return new MerchantOffer(new ItemStack(LAItems.RUBY.get(), this.rubyCost), new ItemStack(this.itemStack.getItem(), this.numberOfItems), this.maxUses, this.pigmanXp, this.priceMultiplier);
    }

    }



    public interface ItemListing {
            @Nullable
            MerchantOffer getOffer(Entity pTrader, Random pRandom);
        }

    }

