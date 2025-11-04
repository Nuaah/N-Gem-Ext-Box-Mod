package com.Nuaah.NGemExtBoxMod.ore;

import com.Nuaah.NGemExtBoxMod.main.NGemExtBoxMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModOreGenSetting extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE,ModOreFeatureConfigurations::bootstrap)
            .add(Registries.PLACED_FEATURE,ModOrePlacedFeature::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS,ModOreBiomeModifier::bootstrap);

    public ModOreGenSetting(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(NGemExtBoxMod.MOD_ID));
    }
}
