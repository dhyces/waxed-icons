package dhyces.modhelper.helpers;

import dhyces.modhelper.services.helpers.PlatformHelper;
import net.fabricmc.api.EnvType;
import org.quiltmc.loader.api.QuiltLoader;
import org.quiltmc.loader.impl.launch.common.QuiltLauncherBase;

public final class QuiltPlatformHelper implements PlatformHelper {
    @Override
    public boolean isModLoaded(String modid) {
        return QuiltLoader.isModLoaded(modid);
    }

    @Override
    public boolean isClientDist() {
        return QuiltLauncherBase.getLauncher().getEnvironmentType().equals(EnvType.CLIENT);
    }
}
