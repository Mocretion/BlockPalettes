package com.mocretion.blockpalettes.gui.draw;


import com.mojang.blaze3d.platform.Lighting;
import net.minecraft.CrashReport;
import net.minecraft.CrashReportCategory;
import net.minecraft.ReportedException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.render.state.GuiItemRenderState;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.item.TrackingItemStackRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;

public class CustomDrawContext {

    private final GuiGraphics context;
    private final Minecraft client;

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

//            TrackingItemStackRenderState trackingItemStackRenderState = new TrackingItemStackRenderState();
//            client.getItemModelResolver().updateForTopItem(trackingItemStackRenderState, stack, ItemDisplayContext.GUI, client.level, null, 0);
//
//            Matrix3x2f matrices = new Matrix3x2f(context.pose());
//
//            matrices.translate((float) (x + 8), (float) (y + 8));//, (float)(150));
//            matrices.scale(scale, -scale);
//
//            try{
//                context.guiRenderState
//                        .submitItem(
//                                new GuiItemRenderState(stack.getItem().getName().toString(), matrices, trackingItemStackRenderState, 0, 0, context.scissorStack.peek())
//                        );
//
//            }catch (Exception e){}
        }

    }
}
