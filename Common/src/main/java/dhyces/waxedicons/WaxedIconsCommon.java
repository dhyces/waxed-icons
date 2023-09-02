package dhyces.waxedicons;

import net.minecraft.resources.ResourceLocation;

// For whatever reason, this makes the IDE throw errors if it's named "WaxedIcons"
public class WaxedIconsCommon {
    public static final String MODID = "waxedicons";
    public static ResourceLocation id(String id) {
        return new ResourceLocation(MODID, id);
    }
}
