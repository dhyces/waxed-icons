package dhyces.modhelper.services.helpers;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;

public interface GuiHelper {
    void setupForRender(boolean enableBlend, boolean enableDepth, ResourceLocation textureLocation);
    boolean shouldRenderSurvivalAspects();
    default boolean rendersMount() {
        return Minecraft.getInstance().player.getVehicle() != null && Minecraft.getInstance().player.getVehicle().showVehicleHealth();
    }
}
