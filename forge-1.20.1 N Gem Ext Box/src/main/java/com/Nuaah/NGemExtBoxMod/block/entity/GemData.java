package com.Nuaah.NGemExtBoxMod.block.entity;

import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class GemData implements CombineGem{
    private final NonNullList<ItemStack> gems = NonNullList.withSize(3, ItemStack.EMPTY);

    @Override
    public List<ItemStack> getGems() {
        return List.copyOf(gems);
    }

    @Override
    public void setGems(List<ItemStack> newGems) {
        for (int i = 0; i < this.gems.size(); i++) {
            this.gems.set(i, i < newGems.size() ? newGems.get(i) : ItemStack.EMPTY);
        }
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        ListTag list = new ListTag();
        for (ItemStack gem : gems) {
            list.add(gem.save(new CompoundTag()));
        }
        tag.put("Gems", list);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        ListTag list = nbt.getList("Gems", Tag.TAG_COMPOUND);
        for (int i = 0; i < gems.size(); i++) {
            gems.set(i, i < list.size() ? ItemStack.of(list.getCompound(i)) : ItemStack.EMPTY);
        }
    }
}
