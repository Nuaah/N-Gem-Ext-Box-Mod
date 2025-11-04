package com.Nuaah.NGemExtBoxMod.regi;

import com.Nuaah.NGemExtBoxMod.item.*;
import com.Nuaah.NGemExtBoxMod.main.NGemExtBoxMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NGemExtBoxModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NGemExtBoxMod.MOD_ID);

    public static final RegistryObject<Item> RUBY_GEM = ITEMS.register("ruby_gem", ItemRubyGem::new);
    public static final RegistryObject<Item> AQUAMARINE_GEM = ITEMS.register("aquamarine_gem", ItemAquamarineGem::new);
    public static final RegistryObject<Item> GARNET_GEM = ITEMS.register("garnet_gem", ItemGarnetGem::new);
    public static final RegistryObject<Item> MOONSTONE_GEM = ITEMS.register("moonstone_gem", ItemMoonstoneGem::new);
    public static final RegistryObject<Item> PERIDOT_GEM = ITEMS.register("peridot_gem", ItemPeridotGem::new);
    public static final RegistryObject<Item> SAPPHIRE_GEM = ITEMS.register("sapphire_gem", ItemSapphireGem::new);
    public static final RegistryObject<Item> TOPAZ_GEM = ITEMS.register("topaz_gem", ItemTopazGem::new);
    public static final RegistryObject<Item> TOURMALINE_GEM = ITEMS.register("tourmaline_gem", ItemTourmalineGem::new);
}
