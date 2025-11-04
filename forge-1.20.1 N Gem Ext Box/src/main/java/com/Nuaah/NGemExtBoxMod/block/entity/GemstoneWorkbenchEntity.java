package com.Nuaah.NGemExtBoxMod.block.entity;

import com.Nuaah.NGemExtBoxMod.block.gui.container.GemstoneWorkbenchMenu;
import com.Nuaah.NGemExtBoxMod.main.NGemExtBoxMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GemstoneWorkbenchEntity extends BlockEntity implements MenuProvider {

    private boolean updatingSlots = false; // 再帰防止フラグ

    // スロット数: 0=防具、1〜3=宝石
    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slotIndex) {
            super.onContentsChanged(slotIndex);

            // 再帰防止
            if (updatingSlots) return;

            updatingSlots = true;

            try {
                ItemStack combineItem = itemHandler.getStackInSlot(0);

                if (!combineItem.isEmpty()) { //上スロットに挿入
                    combineItem.getCapability(NGemExtBoxModCapabilities.GEM_CAP).ifPresent(cap -> {

                        if (slotIndex == 0){
                            for (int i = 1; i <= 3; i++) {
                                itemHandler.setStackInSlot(i, ItemStack.EMPTY);
                            }
                        }

                        // 下スロットに宝石を反映（コピーで安全に）
                        if (slotIndex == 0){
                            for (int i = 1; i <= 3; i++) {
                                ItemStack current = itemHandler.getStackInSlot(i);
                                if (current.isEmpty()) {
                                    ItemStack gem = cap.getGems().get(i - 1);

                                    if (gem != null && !gem.isEmpty()) {
                                        itemHandler.setStackInSlot(i, gem.copy());
                                        System.out.println("setting");
                                    }
                                }
                            }
                        }

                        // 下スロットのItemStackを取得してCapabilityにセット
                        List<ItemStack> gems = List.of(
                                itemHandler.getStackInSlot(1),
                                itemHandler.getStackInSlot(2),
                                itemHandler.getStackInSlot(3)
                        );

//                        combineItem.setTag(cap.serializeNBT()); // NBTに反映
//                        CompoundTag stackTag = combineItem.getOrCreateTag();
//                        stackTag.put("Gems", cap.serializeNBT().getList("Gems", 10)); // 10 = TAG_COMPOUND
//                        combineItem.setTag(stackTag);

                        cap.setGems(gems);

                        CompoundTag capNBT = cap.serializeNBT();
                        CompoundTag stackTag = combineItem.getOrCreateTag();
                        stackTag.put("Gems", capNBT.getList("Gems", 10));
                        combineItem.setTag(stackTag);
                    });
                } else {
                    // 上スロットが空なら下スロットをすべてクリア
                    for (int i = 1; i <= 3; i++) {
                        itemHandler.setStackInSlot(i, ItemStack.EMPTY);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace(); // デバッグ用
            } finally {
                updatingSlots = false; // フラグリセット
            }
        }

        @Override
        public int getSlotLimit(int slot) {
            return 1;
        }

        @Override
        public void setStackInSlot(int slot, @NotNull ItemStack stack) {
            super.setStackInSlot(slot, stack);
        }
    };

    public GemstoneWorkbenchEntity(BlockPos pos, BlockState state) {
        super(NGemExtBoxModBlockEntityTypes.GEMSTONE_WORKBENCH.get(), pos, state);
    }

    // GUI用
    @Override
    public Component getDisplayName() {
        return Component.translatable("container." + NGemExtBoxMod.MOD_ID + ".gemstone_workbench");
    }

//    @Override
//    public AbstractContainerMenu createMenu(int id, Inventory playerInventory, Player player) {
//        return new GemstoneWorkbenchMenu(id, playerInventory, this);
//    }

    // アイテムNBT保存
    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("items", itemHandler.serializeNBT());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("items"));
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        load(tag);
    }

    // スロットアクセス用
    public ItemStackHandler getItemHandler() {
        return itemHandler;
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int a, Inventory inventory, Player player) {
        return new GemstoneWorkbenchMenu(a, inventory, this);
    }
}
