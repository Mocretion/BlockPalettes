package com.mocretion.blockpalettes.gui.draw;


import com.mojang.blaze3d.platform.Lighting;
import net.minecraft.CrashReport;
import net.minecraft.CrashReportCategory;
import net.minecraft.ReportedException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class CustomDrawContext {

    private final GuiGraphicsExtractor context;
    private final Minecraft client;
    private final ItemStackRenderState scratchItemStackRenderState = new ItemStackRenderState();

    public CustomDrawContext(Minecraft client, GuiGraphicsExtractor context) {
        this.client = client;
        this.context = context;
    }

    public void drawItem(ItemStack stack, int x, int y, float scale){
        if (!stack.isEmpty()) {

            var pose = context.pose();
            pose.pushMatrix();
            pose.translate(x - 8, y - 8);
            pose.scale(scale / 16, scale / 16);
            context.item(stack, 0, 0);
            pose.popMatrix();
        }
    }
}