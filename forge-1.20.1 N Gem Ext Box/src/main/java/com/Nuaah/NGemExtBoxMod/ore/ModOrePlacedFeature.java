package com.Nuaah.NGemExtBoxMod.ore;

import com.Nuaah.NGemExtBoxMod.main.NGemExtBoxMod;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

@SuppressWarnings("removal")
public class ModOrePlacedFeature {
    public static final ResourceKey<PlacedFeature> RUBY_ORE_KEY = createKey("ruby_ore");
    public static final ResourceKey<PlacedFeature> AQUAMARINE_ORE_KEY = createKey("aquamarine_ore");
    public static final ResourceKey<PlacedFeature> GARNET_ORE_KEY = createKey("garnet_ore");
    public static final ResourceKey<PlacedFeature> MOONSTONE_ORE_KEY = createKey("moonstone_ore");
    public static final ResourceKey<PlacedFeature> PERIDOT_ORE_KEY = createKey("peridot_ore");
    public static final ResourceKey<PlacedFeature> SAPPHIRE_ORE_KEY = createKey("sapphire_ore");
    public static final ResourceKey<PlacedFeature> TOPAZ_ORE_KEY = createKey("topaz_ore");
    public static final ResourceKey<PlacedFeature> TOURMALINE_ORE_KEY = createKey("tourmaline_ore");

    //生成高度の登録
    public static void bootstrap(BootstapContext<PlacedFeature> context){
        HolderGetter<ConfiguredFeature<?,?>> holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?,?>> ruby_ore = holderGetter.getOrThrow(ModOreFeatureConfigurations.RUBY_ORE_KEY);
        Holder<ConfiguredFeature<?,?>> aquamarine_ore = holderGetter.getOrThrow(ModOreFeatureConfigurations.AQUAMARINE_ORE_KEY);
        Holder<ConfiguredFeature<?,?>> garnet_ore = holderGetter.getOrThrow(ModOreFeatureConfigurations.GARNET_ORE_KEY);
        Holder<ConfiguredFeature<?,?>> moonstone_ore = holderGetter.getOrThrow(ModOreFeatureConfigurations.MOONSTONE_ORE_KEY);
        Holder<ConfiguredFeature<?,?>> peridot_ore = holderGetter.getOrThrow(ModOreFeatureConfigurations.PERIDOT_ORE_KEY);
        Holder<ConfiguredFeature<?,?>> sapphire_ore = holderGetter.getOrThrow(ModOreFeatureConfigurations.SAPPHIRE_ORE_KEY);
        Holder<ConfiguredFeature<?,?>> topaz_ore = holderGetter.getOrThrow(ModOreFeatureConfigurations.TOPAZ_ORE_KEY);
        Holder<ConfiguredFeature<?,?>> tourmaline_ore = holderGetter.getOrThrow(ModOreFeatureConfigurations.TOURMALINE_ORE_KEY);

        // 引数1 1チャンクの生成数 引数2 生成範囲
        PlacementUtils.register(context,SAPPHIRE_ORE_KEY,sapphire_ore,commonOrePlacement(5
                ,HeightRangePlacement.triangle(VerticalAnchor.bottom(),VerticalAnchor.absolute(480))));

        PlacementUtils.register(context,GARNET_ORE_KEY,garnet_ore,commonOrePlacement(5
                ,HeightRangePlacement.triangle(VerticalAnchor.bottom(),VerticalAnchor.absolute(48))));

        PlacementUtils.register(context,RUBY_ORE_KEY,ruby_ore,commonOrePlacement(5
                ,HeightRangePlacement.triangle(VerticalAnchor.bottom(),VerticalAnchor.absolute(-32))));

        PlacementUtils.register(context,AQUAMARINE_ORE_KEY,aquamarine_ore,commonOrePlacement(10
                ,HeightRangePlacement.uniform(VerticalAnchor.bottom(),VerticalAnchor.absolute(-16))));

        PlacementUtils.register(context,TOURMALINE_ORE_KEY,tourmaline_ore,commonOrePlacement(10
                ,HeightRangePlacement.triangle(VerticalAnchor.absolute(-16),VerticalAnchor.absolute(48))));

        PlacementUtils.register(context,MOONSTONE_ORE_KEY,moonstone_ore,commonOrePlacement(10
                ,HeightRangePlacement.triangle(VerticalAnchor.bottom(),VerticalAnchor.absolute(64))));

        PlacementUtils.register(context,PERIDOT_ORE_KEY,peridot_ore,commonOrePlacement(15
                ,HeightRangePlacement.triangle(VerticalAnchor.absolute(-16),VerticalAnchor.absolute(480))));

        PlacementUtils.register(context,TOPAZ_ORE_KEY,topaz_ore,commonOrePlacement(20
                ,HeightRangePlacement.triangle(VerticalAnchor.absolute(-48),VerticalAnchor.absolute(64))));
    }


    public static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(NGemExtBoxMod.MOD_ID,name));
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }
}
