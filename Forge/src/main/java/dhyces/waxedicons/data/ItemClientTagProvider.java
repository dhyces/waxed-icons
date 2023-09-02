package dhyces.waxedicons.data;

import dhyces.trimmed.api.data.tags.ClientRegistryTagDataProvider;
import dhyces.waxedicons.WaxedIconsClient;
import dhyces.waxedicons.WaxedIconsCommon;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ItemClientTagProvider extends ClientRegistryTagDataProvider<Item> {
    public ItemClientTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProviderFuture, ExistingFileHelper existingFileHelper) {
        super(packOutput, WaxedIconsCommon.MODID, lookupProviderFuture, Registries.ITEM, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider lookupProvider) {
        registryAwareTag(WaxedIconsClient.RENDERS_WAXED_ICON, lookupProvider)
                .add(Items.WAXED_COPPER_BLOCK)
                .add(Items.WAXED_CUT_COPPER)
                .add(Items.WAXED_CUT_COPPER_STAIRS)
                .add(Items.WAXED_CUT_COPPER_SLAB)
                .add(Items.WAXED_EXPOSED_COPPER)
                .add(Items.WAXED_EXPOSED_CUT_COPPER)
                .add(Items.WAXED_EXPOSED_CUT_COPPER_STAIRS)
                .add(Items.WAXED_EXPOSED_CUT_COPPER_SLAB)
                .add(Items.WAXED_WEATHERED_COPPER)
                .add(Items.WAXED_WEATHERED_CUT_COPPER)
                .add(Items.WAXED_WEATHERED_CUT_COPPER_STAIRS)
                .add(Items.WAXED_WEATHERED_CUT_COPPER_SLAB)
                .add(Items.WAXED_OXIDIZED_COPPER)
                .add(Items.WAXED_OXIDIZED_CUT_COPPER)
                .add(Items.WAXED_OXIDIZED_CUT_COPPER_STAIRS)
                .add(Items.WAXED_OXIDIZED_CUT_COPPER_SLAB);
    }
}
