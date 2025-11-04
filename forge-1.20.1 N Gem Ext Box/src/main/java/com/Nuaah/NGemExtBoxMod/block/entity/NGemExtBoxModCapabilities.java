package com.Nuaah.NGemExtBoxMod.block.entity;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;

public class NGemExtBoxModCapabilities {

    public static Capability<CombineGem> GEM_CAP = CapabilityManager.get(new CapabilityToken<CombineGem>(){});

    public static void register(RegisterCapabilitiesEvent event) {
        event.register(CombineGem.class);
    }
}
