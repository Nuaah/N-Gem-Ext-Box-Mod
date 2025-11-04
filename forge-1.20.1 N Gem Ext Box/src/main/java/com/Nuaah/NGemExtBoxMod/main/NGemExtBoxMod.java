package com.Nuaah.NGemExtBoxMod.main;

import com.Nuaah.NGemExtBoxMod.block.entity.NGemExtBoxModBlockEntityTypes;
import com.Nuaah.NGemExtBoxMod.block.entity.NGemExtBoxModCapabilities;
import com.Nuaah.NGemExtBoxMod.block.gui.container.NGemExtBoxModContainerTypes;
import com.Nuaah.NGemExtBoxMod.loot.IntroductionLootModifiers;
import com.Nuaah.NGemExtBoxMod.regi.NGemExtBoxModBlocks;
import com.Nuaah.NGemExtBoxMod.regi.NGemExtBoxModItems;
import com.Nuaah.NGemExtBoxMod.regi.tab.NGemExtBoxModTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("ngemextboxmod")
@SuppressWarnings("removal")
public class NGemExtBoxMod {

    public static final String MOD_ID = "ngemextboxmod";

    public NGemExtBoxMod(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        NGemExtBoxModItems.ITEMS.register(bus);
        NGemExtBoxModBlocks.Blocks.BLOCKS.register(bus);
        NGemExtBoxModBlocks.BlockItems.BLOCK_ITEMS.register(bus);
        NGemExtBoxModBlockEntityTypes.BLOCK_ENTITY_TYPES.register(bus);
        NGemExtBoxModContainerTypes.MENU_TYPES.register(bus);
        IntroductionLootModifiers.register(bus);

        NGemExtBoxModTabs.MOD_TABS.register(bus);
    }
}
