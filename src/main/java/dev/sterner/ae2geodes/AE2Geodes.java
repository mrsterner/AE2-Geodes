package dev.sterner.ae2geodes;

import dev.sterner.ae2geodes.common.registry.GeodesConfigFeatures;
import dev.sterner.ae2geodes.common.registry.GeodesFeatures;
import net.fabricmc.api.ModInitializer;

public class AE2Geodes implements ModInitializer {

	@Override
	public void onInitialize() {
		GeodesConfigFeatures.init();
	}
}
