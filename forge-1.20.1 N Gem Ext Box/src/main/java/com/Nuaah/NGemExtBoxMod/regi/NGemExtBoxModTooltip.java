package com.Nuaah.NGemExtBoxMod.regi;

import com.Nuaah.NGemExtBoxMod.block.entity.GemData;
import com.Nuaah.NGemExtBoxMod.block.entity.NGemExtBoxModCapabilities;
import com.Nuaah.NGemExtBoxMod.main.NGemExtBoxMod;
import com.Nuaah.NGemExtBoxMod.regi.tag.NGemExtBoxModTags;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class NGemExtBoxModTooltip {

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        List<Component> tooltip = event.getToolTip();

        if(stack.is(NGemExtBoxModTags.Items.COMBINE_GEMS)){
            tooltip.add(Component.translatable("tooltip.desc." + NGemExtBoxMod.MOD_ID + ".combine.effect").withStyle(ChatFormatting.GOLD));
            tooltip.add(Component.translatable("tooltip.desc." + NGemExtBoxMod.MOD_ID + "." +ForgeRegistries.ITEMS.getKey((stack.getItem())).getPath()).withStyle(ChatFormatting.GRAY));
        }

        stack.getCapability(NGemExtBoxModCapabilities.GEM_CAP).ifPresent(cap -> {
            addGemTooltip(stack,cap.getGems(), tooltip);
        });

        // Capability が無い場合は NBT から復元
        if (!stack.getCapability(NGemExtBoxModCapabilities.GEM_CAP).isPresent() && stack.hasTag() && stack.getTag().contains("Gems")) {
            GemData gemData = new GemData();
            gemData.deserializeNBT(stack.getTag());
            addGemTooltip(stack,gemData.getGems(), tooltip);
        }


//        // まずCapabilityがある場合はそれを使う
//        stack.getCapability(NGemExtBoxModCapabilities.GEM_CAP).ifPresent(cap -> {
//            addGemTooltip(stack, cap.getGems(), tooltip);
//        });
//
//        // Capabilityが無い場合はNBTから復元
//        if (!stack.getCapability(NGemExtBoxModCapabilities.GEM_CAP).isPresent()) {
//            if (stack.hasTag() && stack.getTag().contains("Gems")) {
//                CompoundTag gemsTag = new CompoundTag();
//                gemsTag.put("Gems", stack.getTag().getList("Gems", 10));
//
//                GemData gemData = new GemData();
//                gemData.deserializeNBT(gemsTag);
//                addGemTooltip(stack, gemData.getGems(), tooltip);
//            }
//        }
    }

    private static void addGemTooltip(ItemStack stack, List<ItemStack> gems, List<Component> tooltip){
        boolean hasGem = gems.stream().anyMatch(g -> !g.isEmpty());

        tooltip.add(Component.empty());
        if(hasGem){
            tooltip.add(Component.translatable("tooltip.desc." + NGemExtBoxMod.MOD_ID + ".combine.gem").withStyle(ChatFormatting.GOLD));
            for(ItemStack gem : gems){
                if(!gem.isEmpty()){
                    ResourceLocation id = ForgeRegistries.ITEMS.getKey(gem.getItem());
                    if(id.getNamespace().equals("minecraft")){
                        tooltip.add(Component.translatable(gem.getDescriptionId()));
                    } else {
                        tooltip.add(Component.translatable("tooltip." + NGemExtBoxMod.MOD_ID + "." + id.getPath()));
                    }
                }
            }
        } else {
            tooltip.add(Component.translatable("tooltip.desc." + NGemExtBoxMod.MOD_ID + ".combine.gem").withStyle(ChatFormatting.GRAY));
        }
    }

//if(stack.is(NGemExtBoxModTags.Items.COMBINE_GEMS)){
//        tooltip.add(Component.literal("§6埋め込み効果"));
//        tooltip.add(Component.translatable("tooltip.desc." + NGemExtBoxMod.MOD_ID + "." +ForgeRegistries.ITEMS.getKey((stack.getItem())).getPath()).withStyle(ChatFormatting.GRAY));
//    }
//
//        // Capability取得
//        stack.getCapability(NGemExtBoxModCapabilities.GEM_CAP).ifPresent(cap -> {
//            List<ItemStack> gems = cap.getGems();
//            boolean hasGem = gems.stream().anyMatch(g -> !g.isEmpty());
//
//            if (hasGem) {
//
//                tooltip.add(Component.literal(""));
//                tooltip.add(Component.literal("§6埋め込み宝石"));
//                for (ItemStack gem : gems) {
//                    if (!gem.isEmpty()) {
//                        ResourceLocation id = ForgeRegistries.ITEMS.getKey(gem.getItem());
//                        String gemName = id.getPath();
//
//                        if (id.getNamespace().equals("minecraft")) {
//                            // 既存アイテムは既存の翻訳キーを使用
//                            tooltip.add(Component.translatable(gem.getDescriptionId()));
//                        } else {
//                            tooltip.add(Component.translatable("tooltip." + NGemExtBoxMod.MOD_ID + "." + gemName));
//                        }
//
//
//                    }
//                }
//            } else {
//                tooltip.add(Component.literal(""));
//                tooltip.add(Component.literal("§7埋め込み宝石 なし"));
//            }
//        });

}
