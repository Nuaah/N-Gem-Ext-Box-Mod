package com.Nuaah.NGemExtBoxMod.loot;

import com.Nuaah.NGemExtBoxMod.main.NGemExtBoxMod;
import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class IntroductionLootModifiers {

    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS
                    , NGemExtBoxMod.MOD_ID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_ITEM = //確定追加
            LOOT_MODIFIER_SERIALIZERS.register("add_items",AddItemModifier.CODEC);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> RANDOM_ADD_ITEM = //ランダムで１つ追加
            LOOT_MODIFIER_SERIALIZERS.register("random_add_items",RandomAddItemModifier.CODEC);

    public static void register(IEventBus eventBus){
        LOOT_MODIFIER_SERIALIZERS.register(eventBus);
    }
}
