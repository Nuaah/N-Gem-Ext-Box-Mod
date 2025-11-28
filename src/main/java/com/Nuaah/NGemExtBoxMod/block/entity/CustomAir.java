package com.Nuaah.NGemExtBoxMod.block.entity;

import net.minecraft.nbt.CompoundTag;

public interface CustomAir {
    // カスタム酸素量を取得
    int getAir();
    // カスタム酸素量を設定
    void setAir(int air);
    // 酸素量を減少させる
    void decreaseAir(int amount);
    // データをNBTから読み込む
    void deserializeNBT(CompoundTag nbt);
    // データをNBTに書き込む
    CompoundTag serializeNBT();
}
