package dhyces.waxedicons.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import dhyces.trimmed.api.TrimmedClientTagApi;
import dhyces.waxedicons.WaxedIconsClient;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiGraphics.class)
public class GuiGraphicsMixin {

    @Shadow @Final private PoseStack pose;

    @Inject(method = "renderItemDecorations(Lnet/minecraft/client/gui/Font;Lnet/minecraft/world/item/ItemStack;IILjava/lang/String;)V", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;popPose()V"))
    private void waxedicons$renderWaxedIcon(Font font, ItemStack itemStack, int xOffset, int yOffset, String countString, CallbackInfo ci) {
        if (TrimmedClientTagApi.INSTANCE.registryTagContains(WaxedIconsClient.RENDERS_WAXED_ICON, itemStack.getItem())) {
            pose.popPose();
            WaxedIconsClient.renderIcon((GuiGraphics) (Object) this, font, itemStack, xOffset, yOffset);
            pose.pushPose();
        }
    }
}
