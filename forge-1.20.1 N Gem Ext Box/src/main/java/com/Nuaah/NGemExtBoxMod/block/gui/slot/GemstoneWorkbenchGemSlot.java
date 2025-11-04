package com.Nuaah.NGemExtBoxMod.block.gui.slot;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.Tags;

public class GemstoneWorkbenchGemSlot extends Slot {
    public GemstoneWorkbenchGemSlot(Container container, int slot, int w, int h) {
        super(container, slot, w, h);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return stack.is(Tags.Items.GEMS);
    }
}
