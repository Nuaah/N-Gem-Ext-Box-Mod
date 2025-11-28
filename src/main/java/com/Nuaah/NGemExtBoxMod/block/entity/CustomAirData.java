package com.Nuaah.NGemExtBoxMod.block.entity;

import net.minecraft.nbt.CompoundTag;

public class CustomAirData implements CustomAir{
    private int air = 300; // 初期値

    @Override
    public int getAir() { return this.air; }

    @Override
    public void setAir(int air) { this.air = air; }

    @Override
    public void decreaseAir(int amount) { this.air = Math.max(0, this.air - amount); }

    // NBTへの書き込み
    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("CustomAir", this.air);
        return tag;
    }

    // NBTからの読み込み
    @Override
    public void deserializeNBT(CompoundTag nbt) {
        this.air = nbt.getInt("CustomAir");
    }
}
