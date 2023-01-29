package dev.sterner.ae2geodes.common.registry;


import dev.sterner.ae2geodes.common.utils.Constants;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

public class GeodesFeatures {
    public static final RegistryEntry<PlacedFeature> CERTUS_QUARTZ_GEODE;

    private static RegistryEntry<PlacedFeature> register(String id, PlacedFeature placedFeature) {
        return BuiltinRegistries.add(BuiltinRegistries.PLACED_FEATURE, new Identifier(Constants.MOD_ID, id), placedFeature);
    }

    static {
        CERTUS_QUARTZ_GEODE = register("certus_quartz_geode", new PlacedFeature(GeodesConfigFeatures.CERTUS_QUARTZ_GEODE,
                List.of(
                        RarityFilterPlacementModifier.of(24),
                        SquarePlacementModifier.of(),
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(6), YOffset.fixed(64)),
                        BiomePlacementModifier.of()
                )));
    }
}
