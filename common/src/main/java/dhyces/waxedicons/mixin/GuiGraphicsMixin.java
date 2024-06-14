package dhyces.waxedicons.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.dhyces.trimmed.api.client.TrimmedClientTagApi;
import dev.dhyces.trimmed.api.client.tag.TagHolder;
import dhyces.waxedicons.WaxedIconsClient;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiGraphics.class)
public class GuiGraphicsMixin {

    @Shadow @Final private PoseStack pose;

    @Unique
    private static final TagHolder<Item> WAXED_ICON_HOLDER = TrimmedClientTagApi.getInstance().getTag(WaxedIconsClient.RENDERS_WAXED_ICON);

    @Inject(method = "renderItemDecorations(Lnet/minecraft/client/gui/Font;Lnet/minecraft/world/item/ItemStack;IILjava/lang/String;)V", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;popPose()V"))
    private void waxedicons$renderWaxedIcon(Font font, ItemStack itemStack, int xOffset, int yOffset, String countString, CallbackInfo ci) {
        if (WAXED_ICON_HOLDER.contains(itemStack.getItem())) {
            pose.popPose();
            WaxedIconsClient.renderIcon((GuiGraphics) (Object) this, font, itemStack, xOffset, yOffset);
            pose.pushPose();
        }
    }
}
