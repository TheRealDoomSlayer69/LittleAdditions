package com.TheRealDoomSlayer69.littleadditions.block;

import com.TheRealDoomSlayer69.littleadditions.LittleAdditions;
import com.TheRealDoomSlayer69.littleadditions.block.portal.SkyPortalBlock;
import com.TheRealDoomSlayer69.littleadditions.item.LAItems;
import com.TheRealDoomSlayer69.littleadditions.item.tab.LACreativeModeTab;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class LABlocks {

public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, LittleAdditions.MOD_ID);


    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(4,7f).requiresCorrectToolForDrops()), LACreativeModeTab.LITTLE_ADDITIONS);

    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3,4f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)), LACreativeModeTab.LITTLE_ADDITIONS);

    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3,5f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), LACreativeModeTab.LITTLE_ADDITIONS);

    public static final RegistryObject<Block> NETHER_RUBY_ORE = registerBlock("nether_ruby_ore",
            () -> new OreBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE)
                    .strength(3,4f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)), LACreativeModeTab.LITTLE_ADDITIONS);

    public static final RegistryObject<Block> END_RUBY_ORE = registerBlock("end_ruby_ore",
            () -> new OreBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(3,4f).requiresCorrectToolForDrops(), UniformInt.of(3, 5)), LACreativeModeTab.LITTLE_ADDITIONS);

//MISC ORES
    public static final RegistryObject<Block> END_DIAMOND_ORE = registerBlock("end_diamond_ore",
            () -> new OreBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(3,4f).requiresCorrectToolForDrops(), UniformInt.of(3, 5)), LACreativeModeTab.LITTLE_ADDITIONS);


    public static final RegistryObject<Block> END_LAPIS_ORE = registerBlock("end_lapis_ore",
            () -> new OreBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(3,4f).requiresCorrectToolForDrops(), UniformInt.of(3, 5)), LACreativeModeTab.LITTLE_ADDITIONS);


    public static final RegistryObject<Block> END_IRON_ORE = registerBlock("end_iron_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(3,4f).requiresCorrectToolForDrops()), LACreativeModeTab.LITTLE_ADDITIONS);


    public static final RegistryObject<Block> END_GOLD_ORE = registerBlock("end_gold_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(3,4f).requiresCorrectToolForDrops()), LACreativeModeTab.LITTLE_ADDITIONS);


    public static final RegistryObject<Block> END_COAL_ORE = registerBlock("end_coal_ore",
            () -> new OreBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(3,4f).requiresCorrectToolForDrops(), UniformInt.of(3, 5)), LACreativeModeTab.LITTLE_ADDITIONS);


    public static final RegistryObject<Block> END_COPPER_ORE = registerBlock("end_copper_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(3,4f).requiresCorrectToolForDrops()), LACreativeModeTab.LITTLE_ADDITIONS);


    public static final RegistryObject<Block> END_EMERALD_ORE = registerBlock("end_emerald_ore",
            () -> new OreBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(3,4f).requiresCorrectToolForDrops(), UniformInt.of(3, 5)), LACreativeModeTab.LITTLE_ADDITIONS);

    public static final RegistryObject<Block> END_REDSTONE_ORE = registerBlock("end_redstone_ore",
            () -> new OreBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(2,4f).requiresCorrectToolForDrops(), UniformInt.of(3, 5)), LACreativeModeTab.LITTLE_ADDITIONS);
    public static final RegistryObject<Block> NETHER_DIAMOND_ORE = registerBlock("nether_diamond_ore",
            () -> new OreBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE)
                    .strength(3,4f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)), LACreativeModeTab.LITTLE_ADDITIONS);

    public static final RegistryObject<Block> NETHER_LAPIS_ORE = registerBlock("nether_lapis_ore",
            () -> new OreBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE)
                    .strength(3,4f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)), LACreativeModeTab.LITTLE_ADDITIONS);

    public static final RegistryObject<Block> NETHER_IRON_ORE = registerBlock("nether_iron_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE)
                    .strength(3,4f).requiresCorrectToolForDrops()), LACreativeModeTab.LITTLE_ADDITIONS);

    public static final RegistryObject<Block> NETHER_COAL_ORE = registerBlock("nether_coal_ore",
            () -> new OreBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE)
                    .strength(3,4f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)), LACreativeModeTab.LITTLE_ADDITIONS);

    public static final RegistryObject<Block> NETHER_COPPER_ORE = registerBlock("nether_copper_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE)
                    .strength(3,4f).requiresCorrectToolForDrops()), LACreativeModeTab.LITTLE_ADDITIONS);

    public static final RegistryObject<Block> NETHER_EMERALD_ORE = registerBlock("nether_emerald_ore",
            () -> new OreBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE)
                    .strength(3,4f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)), LACreativeModeTab.LITTLE_ADDITIONS);

    public static final RegistryObject<Block> NETHER_REDSTONE_ORE = registerBlock("nether_redstone_ore",
            () -> new OreBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE)
                    .strength(3,4f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)), LACreativeModeTab.LITTLE_ADDITIONS);

    public static final RegistryObject<Block> STABLE_CRYING_OBSIDIAN = registerBlock("stable_crying_obsidian",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .strength(5,8f).requiresCorrectToolForDrops()), LACreativeModeTab.LITTLE_ADDITIONS);

    public static final RegistryObject<Block> SKY_PORTAL = registerBlockWithoutBlockItem("sky_dimension_portal",
            SkyPortalBlock::new);




    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return LAItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

        private static <T extends Block> RegistryObject<Block> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
            return BLOCKS.register(name, block);
        }





    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
