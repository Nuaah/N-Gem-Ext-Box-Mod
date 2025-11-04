package com.Nuaah.NGemExtBoxMod.ore;

import com.Nuaah.NGemExtBoxMod.main.NGemExtBoxMod;
import com.Nuaah.NGemExtBoxMod.regi.NGemExtBoxModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

@SuppressWarnings("removal")
public class ModOreFeatureConfigurations {
    public static final ResourceKey<ConfiguredFeature<?,?>> RUBY_ORE_KEY = createKey("ruby_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> AQUAMARINE_ORE_KEY = createKey("aquamarine_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> GARNET_ORE_KEY = createKey("garnet_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> MOONSTONE_ORE_KEY = createKey("moonstone_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> PERIDOT_ORE_KEY = createKey("peridot_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> SAPPHIRE_ORE_KEY = createKey("sapphire_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> TOPAZ_ORE_KEY = createKey("topaz_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> TOURMALINE_ORE_KEY = createKey("tourmaline_ore");

    //置き換えるブロック登録
    public static void bootstrap(BootstapContext<ConfiguredFeature<?,?>> context){
        RuleTest stone = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslate = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> ruby_ore_list = List.of( //置き換えリスト
                OreConfiguration.target(stone, NGemExtBoxModBlocks.Blocks.RUBY_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslate, NGemExtBoxModBlocks.Blocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> aquamarine_ore_list = List.of( //置き換えリスト
                OreConfiguration.target(stone, NGemExtBoxModBlocks.Blocks.AQUAMARINE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslate, NGemExtBoxModBlocks.Blocks.DEEPSLATE_AQUAMARINE_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> garnet_ore_list = List.of( //置き換えリスト
                OreConfiguration.target(stone, NGemExtBoxModBlocks.Blocks.GARNET_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslate, NGemExtBoxModBlocks.Blocks.DEEPSLATE_GARNET_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> moonstone_ore_list = List.of( //置き換えリスト
                OreConfiguration.target(stone, NGemExtBoxModBlocks.Blocks.MOONSTONE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslate, NGemExtBoxModBlocks.Blocks.DEEPSLATE_MOONSTONE_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> peridot_ore_list = List.of( //置き換えリスト
                OreConfiguration.target(stone, NGemExtBoxModBlocks.Blocks.PERIDOT_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslate, NGemExtBoxModBlocks.Blocks.DEEPSLATE_PERIDOT_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> sapphire_ore_list = List.of( //置き換えリスト
                OreConfiguration.target(stone, NGemExtBoxModBlocks.Blocks.SAPPHIRE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslate, NGemExtBoxModBlocks.Blocks.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> topaz_ore_list = List.of( //置き換えリスト
                OreConfiguration.target(stone, NGemExtBoxModBlocks.Blocks.TOPAZ_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslate, NGemExtBoxModBlocks.Blocks.DEEPSLATE_TOPAZ_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> tourmaline_ore_list = List.of( //置き換えリスト
                OreConfiguration.target(stone, NGemExtBoxModBlocks.Blocks.TOURMALINE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslate, NGemExtBoxModBlocks.Blocks.DEEPSLATE_TOURMALINE_ORE.get().defaultBlockState())
        );

        //鉱脈設定
        FeatureUtils.register(context,RUBY_ORE_KEY, Feature.ORE,new OreConfiguration(ruby_ore_list,7,0.75F));
        FeatureUtils.register(context,AQUAMARINE_ORE_KEY, Feature.ORE,new OreConfiguration(aquamarine_ore_list,7,0.75F));
        FeatureUtils.register(context,GARNET_ORE_KEY, Feature.ORE,new OreConfiguration(garnet_ore_list,7,0.75F));
        FeatureUtils.register(context,MOONSTONE_ORE_KEY, Feature.ORE,new OreConfiguration(moonstone_ore_list,7,0.75F));
        FeatureUtils.register(context,PERIDOT_ORE_KEY, Feature.ORE,new OreConfiguration(peridot_ore_list,7,1.0F));
        FeatureUtils.register(context,SAPPHIRE_ORE_KEY, Feature.ORE,new OreConfiguration(sapphire_ore_list,7,0.75F));
        FeatureUtils.register(context,TOPAZ_ORE_KEY, Feature.ORE,new OreConfiguration(topaz_ore_list,7,0.75F));
        FeatureUtils.register(context,TOURMALINE_ORE_KEY, Feature.ORE,new OreConfiguration(tourmaline_ore_list,7,0.75F));
    }

    public static ResourceKey<ConfiguredFeature<?,?>> createKey(String name){
        return ResourceKey.create(Registries.CONFIGURED_FEATURE,new ResourceLocation(NGemExtBoxMod.MOD_ID,name));
    }
}
