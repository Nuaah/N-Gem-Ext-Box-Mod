package com.Nuaah.NGemExtBoxMod.block.entity;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GemCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

//    private final GemData backend = new GemData();
//    private final LazyOptional<GemData> optional = LazyOptional.of(() -> backend);

        private final GemData backend;
        private final LazyOptional<GemData> optional;

    // ItemStack から初期化するコンストラクタ
    public GemCapabilityProvider(ItemStack stack) {
        this.backend = new GemData();
        this.optional = LazyOptional.of(() -> backend);

        // すでにItemStackにGemsがある場合は復元
        if (stack.hasTag() && stack.getTag().contains("Gems", 9)) { // 9 = TAG_LIST
            CompoundTag tag = new CompoundTag();
            tag.put("Gems", stack.getTag().getList("Gems", 10)); // 10 = TAG_COMPOUND
            backend.deserializeNBT(tag);
        }
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return cap == NGemExtBoxModCapabilities.GEM_CAP ? optional.cast() : LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        return backend.serializeNBT();
//        CompoundTag tag = new CompoundTag();
//        List<ItemStack> gems = backend.getGems();
//        ListTag listTag = new ListTag();
//        for (ItemStack stack : gems) {
//            listTag.add(stack.save(new CompoundTag()));
//        }
//        tag.put("Gems", listTag);
//        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        backend.deserializeNBT(nbt);
//        ListTag listTag = nbt.getList("Gems", Tag.TAG_COMPOUND);
//        List<ItemStack> list = new ArrayList<>();
//        for (int i = 0; i < listTag.size(); i++) {
//            list.add(ItemStack.of(listTag.getCompound(i)));
//        }
//        backend.setGems(list);
    }

    public void invalidate() {
        optional.invalidate();
    }
}
