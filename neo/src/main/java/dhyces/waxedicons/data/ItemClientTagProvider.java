package dhyces.waxedicons.data;

import dev.dhyces.trimmed.api.data.tag.ClientRegistryTagDataProvider;
import dhyces.waxedicons.WaxedIconsClient;
import dhyces.waxedicons.WaxedIcons;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ItemClientTagProvider extends ClientRegistryTagDataProvider<Item> {
    public ItemClientTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProviderFuture, ExistingFileHelper existingFileHelper) {
        super(packOutput, WaxedIcons.MODID, Registries.ITEM, lookupProviderFuture, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider lookupProvider) {
        tag(WaxedIconsClient.RENDERS_WAXED_ICON, lookupProvider, BuiltInRegistries.ITEM::getKey)
                .add(Items.WAXED_COPPER_BLOCK)
                .add(Items.WAXED_CUT_COPPER)
                .add(Items.WAXED_CUT_COPPER_STAIRS)
                .add(Items.WAXED_CUT_COPPER_SLAB)
                .add(Items.WAXED_CHISELED_COPPER)
                .add(Items.WAXED_COPPER_GRATE)
                .add(Items.WAXED_COPPER_DOOR)
                .add(Items.WAXED_COPPER_TRAPDOOR)
                .add(Items.WAXED_COPPER_BULB)
                .add(Items.WAXED_EXPOSED_COPPER)
                .add(Items.WAXED_EXPOSED_CUT_COPPER)
                .add(Items.WAXED_EXPOSED_CUT_COPPER_STAIRS)
                .add(Items.WAXED_EXPOSED_CUT_COPPER_SLAB)
                .add(Items.WAXED_EXPOSED_CHISELED_COPPER)
                .add(Items.WAXED_EXPOSED_COPPER_GRATE)
                .add(Items.WAXED_EXPOSED_COPPER_DOOR)
                .add(Items.WAXED_EXPOSED_COPPER_TRAPDOOR)
                .add(Items.WAXED_EXPOSED_COPPER_BULB)
                .add(Items.WAXED_WEATHERED_COPPER)
                .add(Items.WAXED_WEATHERED_CUT_COPPER)
                .add(Items.WAXED_WEATHERED_CUT_COPPER_STAIRS)
                .add(Items.WAXED_WEATHERED_CUT_COPPER_SLAB)
                .add(Items.WAXED_WEATHERED_CHISELED_COPPER)
                .add(Items.WAXED_WEATHERED_COPPER_GRATE)
                .add(Items.WAXED_WEATHERED_COPPER_DOOR)
                .add(Items.WAXED_WEATHERED_COPPER_TRAPDOOR)
                .add(Items.WAXED_WEATHERED_COPPER_BULB)
                .add(Items.WAXED_OXIDIZED_COPPER)
                .add(Items.WAXED_OXIDIZED_CUT_COPPER)
                .add(Items.WAXED_OXIDIZED_CUT_COPPER_STAIRS)
                .add(Items.WAXED_OXIDIZED_CUT_COPPER_SLAB)
                .add(Items.WAXED_OXIDIZED_CHISELED_COPPER)
                .add(Items.WAXED_OXIDIZED_COPPER_GRATE)
                .add(Items.WAXED_OXIDIZED_COPPER_DOOR)
                .add(Items.WAXED_OXIDIZED_COPPER_TRAPDOOR)
                .add(Items.WAXED_OXIDIZED_COPPER_BULB);
    }
}
