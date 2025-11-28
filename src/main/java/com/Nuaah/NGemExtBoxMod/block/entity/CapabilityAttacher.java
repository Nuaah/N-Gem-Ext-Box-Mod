package com.Nuaah.NGemExtBoxMod.block.entity;

import com.Nuaah.NGemExtBoxMod.main.NGemExtBoxMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "ngemextboxmod", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CapabilityAttacher {

    @SubscribeEvent
    public static void attachCapabilityEnemy(AttachCapabilitiesEvent<Entity> event){
        if (event.getObject() instanceof Player player) {
            if (!event.getObject().getCapability(NGemExtBoxModCapabilities.CUSTOM_AIR_CAP).isPresent()) {
                // Capabilityがまだ存在しない場合のみ追加
                event.addCapability(
                    // ★Capabilityの識別子 (リソースロケーション)
                    new ResourceLocation(NGemExtBoxMod.MOD_ID, "custom_air"),
                    // Capabilityの実装とNBTシリアライザーを提供するプロバイダー
                    new CustomAirProvider() // このプロバイダーは別途作成が必要
                );
            }
        }
    }

    @SubscribeEvent
    public static void attachCapabilityItem(AttachCapabilitiesEvent<ItemStack> event){
        ItemStack stack = event.getObject();

        if (stack.is(Tags.Items.ARMORS)
            || stack.is(ItemTags.SWORDS)
            || stack.is(ItemTags.PICKAXES)
            || stack.is(ItemTags.AXES)
            || stack.is(ItemTags.SHOVELS)){

            event.addCapability(
                    new ResourceLocation(NGemExtBoxMod.MOD_ID,"gem_cap"),
                    new GemCapabilityProvider(stack)
            );




        }
    }
}
