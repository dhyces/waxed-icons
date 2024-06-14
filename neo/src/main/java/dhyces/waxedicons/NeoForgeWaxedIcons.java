package dhyces.waxedicons;

import dhyces.waxedicons.data.ItemClientTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.data.loading.DatagenModLoader;

import java.util.concurrent.CompletableFuture;

@Mod(WaxedIcons.MODID)
public class NeoForgeWaxedIcons {
    public NeoForgeWaxedIcons(IEventBus modBus) {
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
