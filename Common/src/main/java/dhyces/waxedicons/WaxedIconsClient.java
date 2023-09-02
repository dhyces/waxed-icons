package dhyces.waxedicons;

import com.mojang.blaze3d.vertex.*;
import dhyces.trimmed.impl.client.tags.ClientRegistryTagKey;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class WaxedIconsClient {
    public static final ResourceLocation WAXED_ICON = WaxedIconsCommon.id("textures/gui/waxed_icon.png");

    public static final ClientRegistryTagKey<Item> RENDERS_WAXED_ICON = ClientRegistryTagKey.of(Registries.ITEM, WaxedIconsCommon.id("renders_waxed_icon"));

    public static boolean renderIcon(GuiGraphics guiGraphics, Font font, ItemStack stack, int xOffset, int yOffset) {
        if (!isItemMouseCarried(stack)) {
            PoseStack poseStack = guiGraphics.pose();
            poseStack.pushPose();
            guiGraphics.blit(WaxedIconsClient.WAXED_ICON, xOffset+8, yOffset, 200, 0, 0, 8, 8, 8, 8);
            poseStack.popPose();
            return true;
        }
        return false;
    }

    private static boolean isItemMouseCarried(ItemStack stack) {
        return Minecraft.getInstance().screen instanceof AbstractContainerScreen<?> containerScreen && containerScreen.getMenu().getCarried() == stack;
    }
}
