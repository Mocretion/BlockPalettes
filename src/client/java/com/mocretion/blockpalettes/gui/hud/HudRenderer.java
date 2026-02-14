package com.mocretion.blockpalettes.gui.hud;

import com.mocretion.blockpalettes.BlockPalettesClient;
import com.mocretion.blockpalettes.data.Palette;
import com.mocretion.blockpalettes.data.PaletteManager;
import com.mocretion.blockpalettes.gui.ButtonCatalogue;
import com.mocretion.blockpalettes.gui.ButtonInfo;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;

public class HudRenderer {

    private static final Minecraft client = Minecraft.getInstance();
    private static final Identifier SELECTED_SLOT_HOTBAR = Identifier.fromNamespaceAndPath(BlockPalettesClient.MOD_ID, "selected-slots-hotbar");

    private static final int HOTBARR_WIDTH = 178;
    private static final int HOOTBAR_HEIGHT = 20;

    private static final int OVERLAY_HEIGHT = 18;
    private static final int OVERLAY_Width = 18;

    public static void render(GuiGraphics context, DeltaTracker renderTickCounter) {

        if(client.options.hideGui || !PaletteManager.getIsEnabled() || PaletteManager.getSelectedPalettes().isEmpty())
            return;

        int screenWidth  = client.getWindow().getGuiScaledWidth();
        int screenHeight = client.getWindow().getGuiScaledHeight();

        int x = (screenWidth - HOTBARR_WIDTH) / 2;
        int y = screenHeight - HOOTBAR_HEIGHT;

        for(int enabledSlot : PaletteManager.getSelectedPalettes().keySet()){
            ButtonInfo hudElement = ButtonCatalogue.getHotbarActivePalette(enabledSlot -1);
            context.blit(RenderPipelines.GUI_TEXTURED, hudElement.identifier, x + 20 * (enabledSlot - 1), y, hudElement.u, hudElement.v, OVERLAY_Width, OVERLAY_HEIGHT, 256, 256);
        }
    }

    //public void renderHudAdditions(LayeredDrawerWrapper layeredDrawerWrapper) {
    //    layeredDrawerWrapper.attachLayerAfter(IdentifiedLayer.HOTBAR_AND_BARS, SELECTED_SLOT_HOTBAR, this::render);
    //}
}
