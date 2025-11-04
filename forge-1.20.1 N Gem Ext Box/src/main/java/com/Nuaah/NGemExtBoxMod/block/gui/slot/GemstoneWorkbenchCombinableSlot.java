package com.Nuaah.NGemExtBoxMod.block.gui.slot;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.Tags;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class GemstoneWorkbenchCombinableSlot extends SlotItemHandler {
    public GemstoneWorkbenchCombinableSlot(IItemHandler container, int slot, int w, int h) {
        super(container, slot, w, h);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return stack.is(Tags.Items.ARMORS)
                || stack.is(ItemTags.AXES)
                || stack.is(ItemTags.PICKAXES)
                || stack.is(ItemTags.SHOVELS)
                || stack.is(ItemTags.SWORDS);
    }
}
