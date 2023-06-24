package com.TheRealDoomSlayer69.littleadditions.item.tab;

import com.TheRealDoomSlayer69.littleadditions.item.LAItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class LACreativeModeTab {

    public static final CreativeModeTab LITTLE_ADDITIONS = new CreativeModeTab("littleadditions") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(LAItems.RUBY.get());
        }
    };

}
