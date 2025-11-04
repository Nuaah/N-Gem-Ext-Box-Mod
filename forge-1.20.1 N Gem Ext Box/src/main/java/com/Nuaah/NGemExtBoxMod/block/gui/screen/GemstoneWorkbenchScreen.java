package com.Nuaah.NGemExtBoxMod.block.gui.screen;

import com.Nuaah.NGemExtBoxMod.block.gui.container.GemstoneWorkbenchMenu;
import com.Nuaah.NGemExtBoxMod.main.NGemExtBoxMod;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

@SuppressWarnings("removal")
public class GemstoneWorkbenchScreen extends AbstractContainerScreen<GemstoneWorkbenchMenu> {

    public static final ResourceLocation GEMSTONE_WORKBENCH_TEXTURE = new ResourceLocation(NGemExtBoxMod.MOD_ID,"textures/gui/container/gemstone_workbench.png");

    public static final Component INVENTORY_TITLE = Component.translatable("container." + NGemExtBoxMod.MOD_ID + ".inventory");

    public GemstoneWorkbenchScreen(GemstoneWorkbenchMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
        this.titleLabelX = 8;
        this.titleLabelY = 4;
        this.inventoryLabelX = 8;
        this.inventoryLabelY = this.imageHeight - 92;

    }

    @Override
    public void render(GuiGraphics graphics, int w, int h, float f) {
        this.renderBackground(graphics);
        super.render(graphics, w, h, f);
        this.renderTooltip(graphics, w, h);
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float f, int w, int h) {
        int setW = (this.width - this.imageWidth) / 2;
        int setH = (this.height - this.imageHeight) / 2;
        graphics.blit(GEMSTONE_WORKBENCH_TEXTURE,setW,setH,0,0,this.imageWidth,this.imageHeight);
    }

    @Override
    protected void renderLabels(GuiGraphics graphics, int w, int h) {
        graphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 0x3F3F3F, false);
        graphics.drawString(this.font, this.INVENTORY_TITLE ,this.inventoryLabelX, this.inventoryLabelY, 0x3F3F3F, false);
    }
}
