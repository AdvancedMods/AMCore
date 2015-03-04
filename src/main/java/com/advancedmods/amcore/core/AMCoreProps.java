package com.advancedmods.amcore.core;

/**
 * Common Properties for AMCore
 * Created by Dennisbonke on 8-2-2015.
 *
 * @author Dennis Bonke
 * @since 0.2.0B1
 */
public class AMCoreProps {

    // Versioning
    public static final String REQUIRED_MC_VERSION = "1.7.10";
    public static final String REQUIRED_FORGE_BASE = "10.13.2.1240";
    public static final String FORGE_VERSION = "[" + REQUIRED_FORGE_BASE + "]";
    public static final String VERSION_BASE = "R0.2.1";
    public static final String VERSION_IDENTIFIER = "B1";
    public static final String VERSION_COMPLETE = REQUIRED_MC_VERSION + VERSION_BASE + VERSION_IDENTIFIER;

    // Updating stuff
    public static boolean enableUpdateNotice = true;

    // General Mod Stuff
    public static final String name = "AMCore";
    public static final String modid = "AMCore";
    public static final String version = VERSION_COMPLETE;
    public static final String clientproxy = "com.advancedmods.amcore.client.ClientProxy";
    public static final String commonproxy = "com.advacedmods.amcore.common.CommonProxy";
    public static final String dependencies = "required-after:Forge@" + FORGE_VERSION + ";before:AdvancedFoods";

}
