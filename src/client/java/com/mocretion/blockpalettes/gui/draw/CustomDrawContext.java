package com.mocretion.blockpalettes.gui.draw;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.world.item.ItemStack;

public class CustomDrawContext {

    private final GuiGraphics context;
    private final Minecraft client;
    private final ItemStackRenderState scratchItemStackRenderState = new ItemStackRenderState();

    public CustomDrawContext(Minecraft client, GuiGraphics context) {
        this.client = client;
        this.context = context;
    }

    public void drawItem(ItemStack stack, int x, int y, float scale){
        if (!stack.isEmpty()) {
            var pose = context.pose();
            pose.pushMatrix();
            pose.translate(x - 8, y - 8);
            pose.scale(scale / 16, scale / 16);
            context.renderItem(stack, 0, 0);
            pose.popMatrix();
        }
    }
}
