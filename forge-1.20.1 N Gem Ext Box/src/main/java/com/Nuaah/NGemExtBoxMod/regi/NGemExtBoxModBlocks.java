package com.Nuaah.NGemExtBoxMod.regi;

import com.Nuaah.NGemExtBoxMod.block.*;
import com.Nuaah.NGemExtBoxMod.main.NGemExtBoxMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NGemExtBoxModBlocks {
    public static class Blocks{
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NGemExtBoxMod.MOD_ID);
        public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", BlockRubyOre::new);
        public static final RegistryObject<Block> AQUAMARINE_ORE = BLOCKS.register("aquamarine_ore", BlockAquamarineOre::new);
        public static final RegistryObject<Block> GARNET_ORE = BLOCKS.register("garnet_ore", BlockGarnetOre::new);
        public static final RegistryObject<Block> MOONSTONE_ORE  = BLOCKS.register("moonstone_ore", BlockMoonstoneOre::new);
        public static final RegistryObject<Block> PERIDOT_ORE = BLOCKS.register("peridot_ore", BlockPeridotOre::new);
        public static final RegistryObject<Block> SAPPHIRE_ORE = BLOCKS.register("sapphire_ore", BlockSapphireOre::new);
        public static final RegistryObject<Block> TOPAZ_ORE = BLOCKS.register("topaz_ore", BlockTopazOre::new);
        public static final RegistryObject<Block> TOURMALINE_ORE = BLOCKS.register("tourmaline_ore", BlockTourmalineOre::new);

        public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = BLOCKS.register("deepslate_ruby_ore", BlockDeepslateRubyOre::new);
        public static final RegistryObject<Block> DEEPSLATE_AQUAMARINE_ORE = BLOCKS.register("deepslate_aquamarine_ore", BlockDeepslateRubyOre::new);
        public static final RegistryObject<Block> DEEPSLATE_GARNET_ORE = BLOCKS.register("deepslate_garnet_ore", BlockDeepslateRubyOre::new);
        public static final RegistryObject<Block> DEEPSLATE_MOONSTONE_ORE = BLOCKS.register("deepslate_moonstone_ore", BlockDeepslateRubyOre::new);
        public static final RegistryObject<Block> DEEPSLATE_PERIDOT_ORE = BLOCKS.register("deepslate_peridot_ore", BlockDeepslateRubyOre::new);
        public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = BLOCKS.register("deepslate_sapphire_ore", BlockDeepslateRubyOre::new);
        public static final RegistryObject<Block> DEEPSLATE_TOPAZ_ORE = BLOCKS.register("deepslate_topaz_ore", BlockDeepslateRubyOre::new);
        public static final RegistryObject<Block> DEEPSLATE_TOURMALINE_ORE = BLOCKS.register("deepslate_tourmaline_ore", BlockDeepslateRubyOre::new);

        public static final RegistryObject<Block> GEMSTONE_WORKBENCH = BLOCKS.register("gemstone_workbench", BlockGemstoneWorkbench::new);
    }

    public static class BlockItems{
        public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NGemExtBoxMod.MOD_ID);
        public static final RegistryObject<Item> RUBY_ORE = BLOCK_ITEMS.register("ruby_ore",
                () -> new BlockItem(Blocks.RUBY_ORE.get(),new Item.Properties()));
        public static final RegistryObject<Item> AQUAMARINE_ORE = BLOCK_ITEMS.register("aquamarine_ore",
                () -> new BlockItem(Blocks.AQUAMARINE_ORE.get(),new Item.Properties()));
        public static final RegistryObject<Item> GARNET_ORE = BLOCK_ITEMS.register("garnet_ore",
                () -> new BlockItem(Blocks.GARNET_ORE.get(),new Item.Properties()));
        public static final RegistryObject<Item> MOONSTONE_ORE = BLOCK_ITEMS.register("moonstone_ore",
                () -> new BlockItem(Blocks.MOONSTONE_ORE .get(),new Item.Properties()));
        public static final RegistryObject<Item> PERIDOT_ORE = BLOCK_ITEMS.register("peridot_ore",
                () -> new BlockItem(Blocks.PERIDOT_ORE.get(),new Item.Properties()));
        public static final RegistryObject<Item> SAPPHIRE_ORE = BLOCK_ITEMS.register("sapphire_ore",
                () -> new BlockItem(Blocks.SAPPHIRE_ORE.get(),new Item.Properties()));
        public static final RegistryObject<Item> TOPAZ_ORE = BLOCK_ITEMS.register("topaz_ore",
                () -> new BlockItem(Blocks.TOPAZ_ORE.get(),new Item.Properties()));
        public static final RegistryObject<Item> TOURMALINE_ORE = BLOCK_ITEMS.register("tourmaline_ore",
                () -> new BlockItem(Blocks.TOURMALINE_ORE.get(),new Item.Properties()));

        public static final RegistryObject<Item> DEEPSLATE_RUBY_ORE = BLOCK_ITEMS.register("deepslate_ruby_ore",
                () -> new BlockItem(Blocks.DEEPSLATE_RUBY_ORE.get(),new Item.Properties()));
        public static final RegistryObject<Item> DEEPSLATE_AQUAMARINE_ORE = BLOCK_ITEMS.register("deepslate_aquamarine_ore",
                () -> new BlockItem(Blocks.DEEPSLATE_AQUAMARINE_ORE.get(),new Item.Properties()));
        public static final RegistryObject<Item> DEEPSLATE_GARNET_ORE = BLOCK_ITEMS.register("deepslate_garnet_ore",
                () -> new BlockItem(Blocks.DEEPSLATE_GARNET_ORE.get(),new Item.Properties()));
        public static final RegistryObject<Item> DEEPSLATE_MOONSTONE_ORE = BLOCK_ITEMS.register("deepslate_moonstone_ore",
                () -> new BlockItem(Blocks.DEEPSLATE_MOONSTONE_ORE.get(),new Item.Properties()));
        public static final RegistryObject<Item> DEEPSLATE_PERIDOT_ORE = BLOCK_ITEMS.register("deepslate_peridot_ore",
                () -> new BlockItem(Blocks.DEEPSLATE_PERIDOT_ORE.get(),new Item.Properties()));
        public static final RegistryObject<Item> DEEPSLATE_SAPPHIRE_ORE = BLOCK_ITEMS.register("deepslate_sapphire_ore",
                () -> new BlockItem(Blocks.DEEPSLATE_SAPPHIRE_ORE.get(),new Item.Properties()));
        public static final RegistryObject<Item> DEEPSLATE_TOPAZ_ORE = BLOCK_ITEMS.register("deepslate_topaz_ore",
                () -> new BlockItem(Blocks.DEEPSLATE_TOPAZ_ORE.get(),new Item.Properties()));
        public static final RegistryObject<Item> DEEPSLATE_TOURMALINE_ORE = BLOCK_ITEMS.register("deepslate_tourmaline_ore",
                () -> new BlockItem(Blocks.DEEPSLATE_TOURMALINE_ORE.get(),new Item.Properties()));

        public static final RegistryObject<Item> GEMSTONE_WORKBENCH = BLOCK_ITEMS.register("gemstone_workbench",
                () -> new BlockItem(Blocks.GEMSTONE_WORKBENCH.get(),new Item.Properties()));
    }
}
