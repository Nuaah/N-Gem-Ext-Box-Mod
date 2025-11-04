package com.Nuaah.NGemExtBoxMod.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.Tags;

public class ItemRubyGem extends Item {
    public ItemRubyGem() {
        super(new Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (stack.is(Tags.Items.GEMS)){
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

        return InteractionResultHolder.consume(stack);
    }
}
