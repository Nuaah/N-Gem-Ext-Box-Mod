package com.Nuaah.NGemExtBoxMod.block.entity;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CustomAirProvider implements ICapabilitySerializable<CompoundTag> {
    // Capabilityの実装クラスのインスタンスを作成
    private final CustomAirData customAir = new CustomAirData();

    // LazyOptionalを使ってCapabilityの実装をラップします
    private final LazyOptional<CustomAir> airOptional = LazyOptional.of(() -> customAir);

    // ICapabilityProviderの実装
    // 他のクラスからCapabilityを取得する際に呼ばれます
    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        // 要求されたCapabilityが ModCapabilities.CUSTOM_AIR であるか確認
        if (cap == NGemExtBoxModCapabilities.CUSTOM_AIR_CAP) {
            // そうであれば、LazyOptionalを返す
            // as() メソッドで型変換を試みます
            return airOptional.cast();
        }
        // それ以外の場合は空のLazyOptionalを返す
        return LazyOptional.empty();
    }

    // NBTデータとして保存する処理
    @Override
    public CompoundTag serializeNBT() {
        // CustomAirクラスの serializeNBT() メソッドを呼び出し、CompoundTagを取得
        return customAir.serializeNBT();
    }

    // NBTデータからロードする処理
    @Override
    public void deserializeNBT(CompoundTag nbt) {
        // CustomAirクラスの deserializeNBT() メソッドを呼び出し、データを復元
        customAir.deserializeNBT(nbt);
    }
}
