package com.Nuaah.NGemExtBoxMod.regi.tab;

import com.Nuaah.NGemExtBoxMod.main.NGemExtBoxMod;
import com.Nuaah.NGemExtBoxMod.regi.NGemExtBoxModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class NGemExtBoxModTabs {

    public static final DeferredRegister<CreativeModeTab> MOD_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NGemExtBoxMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> NGEMEXTBOX_MAIN = MOD_TABS.register("ngemextbox_main",
            () -> {return CreativeModeTab.builder()
                    .icon(() -> new ItemStack(NGemExtBoxModItems.RUBY_GEM.get()))
                    .title(Component.translatable("itemGroup.NGemExtBoxMain"))
                    .displayItems((param,output) -> {
                        for(Item item : NGemExtBoxMain.items){
                            output.accept(item);
                        }
                    })
                    .build();
    });
}
