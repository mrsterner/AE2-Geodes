package dev.sterner.ae2geodes.common.registry;

import appeng.core.definitions.AEBlocks;
import com.google.common.collect.ImmutableList;
import dev.sterner.ae2geodes.common.utils.Constants;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;

import java.util.Objects;
import java.util.function.Predicate;

public class GeodesConfigFeatures {
    public static final RegistryEntry<ConfiguredFeature<?, ?>> CERTUS_QUARTZ_GEODE;

    private static RegistryEntry<ConfiguredFeature<?, ?>> register(String id, ConfiguredFeature<?, ?> configuredFeature) {
        return BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Constants.MOD_ID, id), configuredFeature);
    }

    public static void init(){
        addGeodeToBiomes(
                BiomeSelectors.all(),
                GeodesFeatures.CERTUS_QUARTZ_GEODE,
                true
        );
    }
ClientPlayNetworkHandler

    private static void addGeodeToBiomes(Predicate<BiomeSelectionContext> biomeSelector, RegistryEntry<PlacedFeature> geode, boolean shouldAdd, GenerationStep.Feature step) {
        if (shouldAdd) {
            BiomeModifications.addFeature(
                    biomeSelector,
                    step,
                    Objects.requireNonNull(geode.getKey().orElse(null))
            );
        }
    }
    private static void addGeodeToBiomes(Predicate<BiomeSelectionContext> biomeSelector, RegistryEntry<PlacedFeature> geode, boolean shouldAdd) {
        addGeodeToBiomes(biomeSelector, geode, shouldAdd, GenerationStep.Feature.UNDERGROUND_DECORATION);
    }

    static {
        CERTUS_QUARTZ_GEODE = register("certus_quartz_geode", new ConfiguredFeature<>(Feature.GEODE, new GeodeFeatureConfig
                (
                        new GeodeLayerConfig
                                (
                                        SimpleBlockStateProvider.of(Blocks.AIR.getDefaultState()),
                                        SimpleBlockStateProvider.of(AEBlocks.QUARTZ_BLOCK.block().getDefaultState()),
                                        SimpleBlockStateProvider.of(AEBlocks.FLAWED_BUDDING_QUARTZ.block().getDefaultState()),
                                        SimpleBlockStateProvider.of(Blocks.CALCITE.getDefaultState()),
                                        SimpleBlockStateProvider.of(Blocks.SMOOTH_BASALT.getDefaultState()),
                                        ImmutableList.of(AEBlocks.FLAWED_BUDDING_QUARTZ.block().getDefaultState(), AEBlocks.DAMAGED_BUDDING_QUARTZ.block().getDefaultState(), AEBlocks.CHIPPED_BUDDING_QUARTZ.block().getDefaultState()),
                                        BlockTags.FEATURES_CANNOT_REPLACE,
                                        BlockTags.GEODE_INVALID_BLOCKS
                                ),
                        new GeodeLayerThicknessConfig(1.7D, 2.2D, 3.2D, 4.2D),
                        new GeodeCrackConfig(0.95D, 2.0D, 2),
                        0.35D, 0.083D, true,
                        UniformIntProvider.create(4, 6),
                        UniformIntProvider.create(3, 4),
                        UniformIntProvider.create(1, 2),
                        -16, 16, 0.05D, 1
                )
        ));
    }
}
