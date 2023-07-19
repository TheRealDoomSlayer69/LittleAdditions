package com.TheRealDoomSlayer69.littleadditions.datagen.provider;

import com.TheRealDoomSlayer69.littleadditions.block.LABlocks;
import com.TheRealDoomSlayer69.littleadditions.item.LAItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class LARecipeProvider extends RecipeProvider implements IConditionBuilder {

public LARecipeProvider(DataGenerator pGenerator) {
    super(pGenerator);
    }

    @Override
    public void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        ShapelessRecipeBuilder.shapeless(LAItems.RUBY.get())
                .requires(LABlocks.RUBY_BLOCK.get())
                .unlockedBy("has_ruby_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(LABlocks.RUBY_BLOCK.get()).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(LABlocks.RUBY_BLOCK.get())
                .define('R', LAItems.RUBY.get())
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .unlockedBy("has_ruby", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(LAItems.RUBY.get()).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(LAItems.RUBY_HELMET.get())
                .define('R', LAItems.RUBY.get())
                .pattern("RRR")
                .pattern("R R")
                .unlockedBy("has_ruby", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(LAItems.RUBY.get()).build()))
                .save(pFinishedRecipeConsumer);
    }
}
