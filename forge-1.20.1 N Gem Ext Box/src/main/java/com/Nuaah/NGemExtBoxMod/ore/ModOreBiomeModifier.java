package com.Nuaah.NGemExtBoxMod.ore;

import com.Nuaah.NGemExtBoxMod.main.NGemExtBoxMod;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("removal")
public class ModOreBiomeModifier {
    public static final ResourceKey<BiomeModifier> RUBY_ORE_KEY = createKey("ruby_ore");
    public static final ResourceKey<BiomeModifier> AQUAMARINE_ORE_KEY = createKey("aquamarine_ore");
    public static final ResourceKey<BiomeModifier> GARNET_ORE_KEY = createKey("garnet_ore");
    public static final ResourceKey<BiomeModifier> MOONSTONE_ORE_KEY = createKey("moonstone_ore");
    public static final ResourceKey<BiomeModifier> PERIDOT_ORE_KEY = createKey("peridot_ore");
    public static final ResourceKey<BiomeModifier> SAPPHIRE_ORE_KEY = createKey("sapphire_ore");
    public static final ResourceKey<BiomeModifier> TOPAZ_ORE_KEY = createKey("topaz_ore");
    public static final ResourceKey<BiomeModifier> TOURMALINE_ORE_KEY = createKey("tourmaline_ore");

    public static void bootstrap(BootstapContext<BiomeModifier> context){
        HolderGetter<Biome> biome = context.lookup((Registries.BIOME));
        HolderGetter<PlacedFeature> placedFeature = context.lookup(Registries.PLACED_FEATURE);

        // 生成バイオーム設定
        context.register(RUBY_ORE_KEY,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(BiomeTags.IS_OVERWORLD), //バイオーム
                HolderSet.direct(placedFeature.getOrThrow(ModOrePlacedFeature.RUBY_ORE_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(AQUAMARINE_ORE_KEY,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(BiomeTags.IS_OVERWORLD), //バイオーム
                HolderSet.direct(placedFeature.getOrThrow(ModOrePlacedFeature.AQUAMARINE_ORE_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(GARNET_ORE_KEY,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(BiomeTags.IS_OVERWORLD), //バイオーム
                HolderSet.direct(placedFeature.getOrThrow(ModOrePlacedFeature.GARNET_ORE_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(MOONSTONE_ORE_KEY,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(BiomeTags.IS_OVERWORLD), //バイオーム
                HolderSet.direct(placedFeature.getOrThrow(ModOrePlacedFeature.MOONSTONE_ORE_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(PERIDOT_ORE_KEY,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(BiomeTags.IS_OVERWORLD), //バイオーム
                HolderSet.direct(placedFeature.getOrThrow(ModOrePlacedFeature.PERIDOT_ORE_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(SAPPHIRE_ORE_KEY,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(BiomeTags.IS_OVERWORLD), //バイオーム
                HolderSet.direct(placedFeature.getOrThrow(ModOrePlacedFeature.SAPPHIRE_ORE_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(TOPAZ_ORE_KEY,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(BiomeTags.IS_OVERWORLD), //バイオーム
                HolderSet.direct(placedFeature.getOrThrow(ModOrePlacedFeature.TOPAZ_ORE_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(TOURMALINE_ORE_KEY,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biome.getOrThrow(BiomeTags.IS_OVERWORLD), //バイオーム
                HolderSet.direct(placedFeature.getOrThrow(ModOrePlacedFeature.TOURMALINE_ORE_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
    }

    public static ResourceKey<BiomeModifier> createKey(String name){
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS,new ResourceLocation(NGemExtBoxMod.MOD_ID,name));
    }
}
