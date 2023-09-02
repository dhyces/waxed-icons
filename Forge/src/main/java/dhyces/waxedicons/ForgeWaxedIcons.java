package dhyces.waxedicons;

import dhyces.waxedicons.data.ItemClientTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.data.loading.DatagenModLoader;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.concurrent.CompletableFuture;

@Mod(WaxedIconsCommon.MODID)
public class ForgeWaxedIcons {
    public ForgeWaxedIcons() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        if (DatagenModLoader.isRunningDataGen()) {
            modBus.addListener(this::datagen);
        }
    }

    private void datagen(final GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new ItemClientTagProvider(packOutput, lookupProvider, fileHelper));
    }
}
