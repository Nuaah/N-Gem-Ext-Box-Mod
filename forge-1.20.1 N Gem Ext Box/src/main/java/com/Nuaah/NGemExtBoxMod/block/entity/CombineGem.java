package com.Nuaah.NGemExtBoxMod.block.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public interface CombineGem {
    List<ItemStack> getGems();
    void setGems(List<ItemStack> gems);

    CompoundTag serializeNBT();

    void deserializeNBT(CompoundTag nbt);
}
