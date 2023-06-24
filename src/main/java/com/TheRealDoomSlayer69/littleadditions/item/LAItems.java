package com.TheRealDoomSlayer69.littleadditions.item;

import com.TheRealDoomSlayer69.littleadditions.LittleAdditions;
import com.TheRealDoomSlayer69.littleadditions.entity.LAEntities;
import com.TheRealDoomSlayer69.littleadditions.item.armor.EmeraldArmorItem;
import com.TheRealDoomSlayer69.littleadditions.item.armor.LAArmorMaterials;
import com.TheRealDoomSlayer69.littleadditions.item.armor.LAArmorMaterials1;
import com.TheRealDoomSlayer69.littleadditions.item.igniter.LAIgniter;
import com.TheRealDoomSlayer69.littleadditions.item.tab.LACreativeModeTab;
import com.TheRealDoomSlayer69.littleadditions.item.tier.LATiers;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LAItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LittleAdditions.MOD_ID);


    public static final RegistryObject<Item> RUBY =
            ITEMS.register("ruby", () -> new Item(new Item.Properties().tab(LACreativeModeTab.LITTLE_ADDITIONS)));

    //Tools
    //RUBY
    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new SwordItem(LATiers.RUBY, 4, -2.4f,
                    new Item.Properties().tab(LACreativeModeTab.LITTLE_ADDITIONS)));
    
    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(LATiers.RUBY, -2, -2.8f,
                    new Item.Properties().tab(LACreativeModeTab.LITTLE_ADDITIONS)));
    
    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new ShovelItem(LATiers.RUBY, -2, -2.8f,
                    new Item.Properties().tab(LACreativeModeTab.LITTLE_ADDITIONS)));
    
    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new AxeItem(LATiers.RUBY, 5, -2.8f,
                    new Item.Properties().tab(LACreativeModeTab.LITTLE_ADDITIONS)));
    
    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe",
            () -> new HoeItem(LATiers.RUBY, -2, -2.8f,
                    new Item.Properties().tab(LACreativeModeTab.LITTLE_ADDITIONS)));


    //EMERALD
    public static final RegistryObject<Item> EMERALD_SWORD = ITEMS.register("emerald_sword",
            () -> new SwordItem(LATiers.EMERALD, 3, -2.4f,
                    new Item.Properties().tab(LACreativeModeTab.LITTLE_ADDITIONS)));
    
    public static final RegistryObject<Item> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe",
            () -> new PickaxeItem(LATiers.EMERALD, -2, -2.8f,
                    new Item.Properties().tab(LACreativeModeTab.LITTLE_ADDITIONS)));
    
    public static final RegistryObject<Item> EMERALD_SHOVEL = ITEMS.register("emerald_shovel",
            () -> new ShovelItem(LATiers.EMERALD, -2, -2.8f,
                    new Item.Properties().tab(LACreativeModeTab.LITTLE_ADDITIONS)));
    
    public static final RegistryObject<Item> EMERALD_AXE = ITEMS.register("emerald_axe",
            () -> new AxeItem(LATiers.EMERALD, 4, -2.8f,
                    new Item.Properties().tab(LACreativeModeTab.LITTLE_ADDITIONS)));
    
    public static final RegistryObject<Item> EMERALD_HOE = ITEMS.register("emerald_hoe",
            () -> new HoeItem(LATiers.EMERALD, -3, -2.8f,
                    new Item.Properties().tab(LACreativeModeTab.LITTLE_ADDITIONS)));
    
    //Armor
    //RUBY
    public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet",
            () -> new ArmorItem(LAArmorMaterials.RUBY, EquipmentSlot.HEAD,
                    new Item.Properties().tab(LACreativeModeTab.LITTLE_ADDITIONS)));

    public static final RegistryObject<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
            () -> new ArmorItem(LAArmorMaterials.RUBY, EquipmentSlot.CHEST,
                    new Item.Properties().tab(LACreativeModeTab.LITTLE_ADDITIONS)));

    public static final RegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
            () -> new ArmorItem(LAArmorMaterials.RUBY, EquipmentSlot.LEGS,
                    new Item.Properties().tab(LACreativeModeTab.LITTLE_ADDITIONS)));

    public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots",
            () -> new ArmorItem(LAArmorMaterials.RUBY, EquipmentSlot.FEET,
                    new Item.Properties().tab(LACreativeModeTab.LITTLE_ADDITIONS)));

    public static final RegistryObject<Item> RUBY_HORSE_ARMOR = ITEMS.register("ruby_horse_armor",
            () -> new HorseArmorItem(12, "ruby",
                    new Item.Properties().tab(LACreativeModeTab.LITTLE_ADDITIONS).stacksTo(1)));


    //EMERALD
    public static final RegistryObject<Item> EMERALD_HELMET = ITEMS.register("emerald_helmet",
            () -> new EmeraldArmorItem(LAArmorMaterials1.EMERALD, EquipmentSlot.HEAD,
                    new Item.Properties().tab(LACreativeModeTab.LITTLE_ADDITIONS)));

    public static final RegistryObject<Item> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate",
            () -> new EmeraldArmorItem(LAArmorMaterials1.EMERALD, EquipmentSlot.CHEST,
                    new Item.Properties().tab(LACreativeModeTab.LITTLE_ADDITIONS)));

    public static final RegistryObject<Item> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings",
            () -> new EmeraldArmorItem(LAArmorMaterials1.EMERALD, EquipmentSlot.LEGS,
                    new Item.Properties().tab(LACreativeModeTab.LITTLE_ADDITIONS)));

    public static final RegistryObject<Item> EMERALD_BOOTS = ITEMS.register("emerald_boots",
            () -> new EmeraldArmorItem(LAArmorMaterials1.EMERALD, EquipmentSlot.FEET,
                    new Item.Properties().tab(LACreativeModeTab.LITTLE_ADDITIONS)));

    public static final RegistryObject<Item> EMERALD_HORSE_ARMOR = ITEMS.register("emerald_horse_armor",
            () -> new HorseArmorItem(12, "emerald",
                    new Item.Properties().tab(LACreativeModeTab.LITTLE_ADDITIONS).stacksTo(1)));

    public static final RegistryObject<ForgeSpawnEggItem> PIGMAN_SPAWN_EGG = ITEMS.register("pigman_spawn_egg",
            () -> new ForgeSpawnEggItem(LAEntities.PIGMAN,11956611, 111846,
                    new Item.Properties().tab(LACreativeModeTab.LITTLE_ADDITIONS)));

    public static final RegistryObject<ForgeSpawnEggItem> ZOMBIE_PIGMAN_SPAWN_EGG = ITEMS.register("zombie_pigman_spawn_egg",
            () -> new ForgeSpawnEggItem(LAEntities.ZOMBIE_PIGMAN,11857621, 279846,
                    new Item.Properties().tab(LACreativeModeTab.LITTLE_ADDITIONS)));

    public static final RegistryObject<Item> GOLD_AND_RUBY = ITEMS.register("gold_and_ruby", LAIgniter::new);



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
