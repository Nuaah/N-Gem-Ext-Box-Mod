package com.Nuaah.NGemExtBoxMod.block.entity;

import com.Nuaah.NGemExtBoxMod.main.NGemExtBoxMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.ibm.icu.impl.CurrencyData.provider;

@Mod.EventBusSubscriber(modid = "ngemextboxmod", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class GemCapabilityAttacher {

    @SubscribeEvent
    public static void attachCapability(AttachCapabilitiesEvent<ItemStack> event){
        ItemStack stack = event.getObject();
        Item item = stack.getItem();

        if (item instanceof ArmorItem
        || item instanceof SwordItem
        || item instanceof PickaxeItem
        || item instanceof AxeItem
        || item instanceof ShovelItem ){

            GemCapabilityProvider provider = new GemCapabilityProvider(stack);

            event.addCapability(
                new ResourceLocation(NGemExtBoxMod.MOD_ID,"gem_cap"),
                    provider
            );

            event.addListener(provider::invalidate);
        }
    }
}
