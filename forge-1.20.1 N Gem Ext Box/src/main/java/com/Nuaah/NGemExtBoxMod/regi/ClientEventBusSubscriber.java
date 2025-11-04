package com.Nuaah.NGemExtBoxMod.regi;

import com.Nuaah.NGemExtBoxMod.block.entity.NGemExtBoxModCapabilities;
import com.Nuaah.NGemExtBoxMod.block.gui.container.NGemExtBoxModContainerTypes;
import com.Nuaah.NGemExtBoxMod.block.gui.screen.GemstoneWorkbenchScreen;
import com.Nuaah.NGemExtBoxMod.main.NGemExtBoxMod;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = NGemExtBoxMod.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void slientSetup(FMLClientSetupEvent event){
        blockScreenRegister();
    }

    private static void blockScreenRegister(){
        MenuScreens.register(NGemExtBoxModContainerTypes.GEMSTONE_WORKBENCH.get(), GemstoneWorkbenchScreen::new);
    }


}
