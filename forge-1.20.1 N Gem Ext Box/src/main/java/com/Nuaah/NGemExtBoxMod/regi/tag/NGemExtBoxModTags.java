package com.Nuaah.NGemExtBoxMod.regi.tag;

import com.Nuaah.NGemExtBoxMod.main.NGemExtBoxMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

@SuppressWarnings("removal")
public class NGemExtBoxModTags {

    public static class Blocks{
        public static final TagKey<Block> ORES_AQUAMARINE = tag("ores_aquamarine");
        public static final TagKey<Block> ORES_GARNET = tag("ores_garnet");
        public static final TagKey<Block> ORES_MOONSTONE = tag("ores_moonstone");
        public static final TagKey<Block> ORES_PERIDOT = tag("ores_peridot");
        public static final TagKey<Block> ORES_RUBY = tag("ores_ruby");
        public static final TagKey<Block> ORES_SAPPHIRE = tag("ores_sapphire");
        public static final TagKey<Block> ORES_TOPAZ = tag("ores_topaz");
        public static final TagKey<Block> ORES_TOURMALINE = tag("ores_tourmaline");

        public static TagKey<Block> tag (String name){
            return BlockTags.create(new ResourceLocation(NGemExtBoxMod.MOD_ID,name));
        }
    }

    public static class Items{
        public static final TagKey<Item> GEMS_AQUAMARINE = tag("gems_aquamarine");
        public static final TagKey<Item> GEMS_GARNET = tag("gems_garnet");
        public static final TagKey<Item> GEMS_MOONSTONE = tag("gems_moonstone");
        public static final TagKey<Item> GEMS_PERIDOT = tag("gems_peridot");
        public static final TagKey<Item> GEMS_RUBY = tag("gems_ruby");
        public static final TagKey<Item> GEMS_SAPPHIRE = tag("gems_sapphire");
        public static final TagKey<Item> GEMS_TOPAZ = tag("gems_topaz");
        public static final TagKey<Item> GEMS_TOURMALINE = tag("gems_tourmaline");

        public static final TagKey<Item> COMBINE_ARMOR_GEMS = tag("combine_armor_gems");
        public static final TagKey<Item> COMBINE_TOOL_GEMS = tag("combine_tool_gems");
        public static final TagKey<Item> COMBINE_GEMS = tag("combine_gems");

        public static TagKey<Item> tag (String name){
            return ItemTags.create(new ResourceLocation(NGemExtBoxMod.MOD_ID,name));
        }
    }
}
