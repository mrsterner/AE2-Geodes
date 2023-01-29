package dev.sterner.ae2geodes.common.utils;

import net.minecraft.util.Identifier;

public class Constants {
    public static final String MOD_ID = "ae2geodes";

    public static Identifier id(String name) {
        return new Identifier(MOD_ID, name);
    }
}
