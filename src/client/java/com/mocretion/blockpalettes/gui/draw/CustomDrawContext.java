package com.mocretion.blockpalettes.gui.draw;


import com.mojang.blaze3d.platform.Lighting;
import net.minecraft.CrashReport;
import net.minecraft.CrashReportCategory;
import net.minecraft.ReportedException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.world.item.ItemStack;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;

public class CustomDrawContext {

    private final GuiGraphicsExtractor context;
    private final Minecraft client;

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
