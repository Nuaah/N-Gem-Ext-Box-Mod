package com.Nuaah.NGemExtBoxMod.block.gui.container;

import com.Nuaah.NGemExtBoxMod.block.entity.GemstoneWorkbenchEntity;
import com.Nuaah.NGemExtBoxMod.block.gui.slot.GemstoneWorkbenchCombinableSlot;
import com.Nuaah.NGemExtBoxMod.block.gui.slot.GemstoneWorkbenchGemSlot;
import com.Nuaah.NGemExtBoxMod.regi.tag.NGemExtBoxModTags;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.Tags;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

public class GemstoneWorkbenchMenu extends AbstractContainerMenu {
    private final GemstoneWorkbenchEntity blockEntity;

    // ★ クライアント側用
    public GemstoneWorkbenchMenu(int id, Inventory playerInv, FriendlyByteBuf buf) {
        this(id, playerInv, (GemstoneWorkbenchEntity) playerInv.player.level()
                .getBlockEntity(buf.readBlockPos()));
    }

    public GemstoneWorkbenchMenu(int id, Inventory playerInventory, GemstoneWorkbenchEntity entity) {
        super(NGemExtBoxModContainerTypes.GEMSTONE_WORKBENCH.get(), id);
        this.blockEntity = entity;

        IItemHandler handler = entity.getItemHandler();

        // --- スロット定義 ---
        // 防具スロット (0)
        this.addSlot(new GemstoneWorkbenchCombinableSlot(handler, 0, 80, 21));

        // 宝石スロット (1〜3)
        for (int i = 0; i < 3; i++) {
            this.addSlot(new SlotItemHandler(handler, 1 + i, 46 + i * 34, 49) {

                @Override
                public int getMaxStackSize() {
                    return 1;
                }

                @Override
                public boolean mayPlace(ItemStack stack) {
                    ItemStack combineSlot = handler.getStackInSlot(0);

                    if (combineSlot.isEmpty()) return false;

                    if(combineSlot.is(Tags.Items.ARMORS)){
                        return stack.is(Tags.Items.GEMS) && stack.is(NGemExtBoxModTags.Items.COMBINE_ARMOR_GEMS);
                    }

                    if(combineSlot.is(ItemTags.SWORDS) || combineSlot.is(ItemTags.PICKAXES) || combineSlot.is(ItemTags.AXES) || combineSlot.is(ItemTags.SHOVELS)){
                        return stack.is(Tags.Items.GEMS) && stack.is(NGemExtBoxModTags.Items.COMBINE_TOOL_GEMS);
                    }

                    return false;
                }
            });
        }

        // --- プレイヤーインベントリ ---
        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
        }
    }

    // --- Shiftクリック処理 ---
    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack original = slot.getItem();
            newStack = original.copy();

            int containerSlots = blockEntity.getItemHandler().getSlots();
            if (index < containerSlots) {
                if (!this.moveItemStackTo(original, containerSlots, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(original, 0, containerSlots, false)) {
                return ItemStack.EMPTY;
            }

            if (original.isEmpty()) slot.setByPlayer(ItemStack.EMPTY);
            else slot.setChanged();
        }
        return newStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return blockEntity != null && player.distanceToSqr(
                blockEntity.getBlockPos().getX() + 0.5D,
                blockEntity.getBlockPos().getY() + 0.5D,
                blockEntity.getBlockPos().getZ() + 0.5D
        ) <= 64.0D;
    }
}
