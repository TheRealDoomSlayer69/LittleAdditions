package com.TheRealDoomSlayer69.littleadditions.item.tier;

import com.TheRealDoomSlayer69.littleadditions.item.LAItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class LATiers {

public static final ForgeTier RUBY = new ForgeTier( 5, 3000, 5f,
        4f, 20, BlockTags.NEEDS_DIAMOND_TOOL,
        () -> Ingredient.of(LAItems.RUBY.get()));

    public static final ForgeTier EMERALD = new ForgeTier( 5, 2500, 4f,
            3f, 10, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(Items.EMERALD.getDefaultInstance()));


}


