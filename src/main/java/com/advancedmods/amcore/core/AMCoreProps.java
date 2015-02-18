package com.advancedmods.amcore.core;

/**
 * Created by Dennisbonke on 8-2-2015.
 */
public class AMCoreProps {

    // Versioning
    public static final String REQUIRED_MC_VERSION = "1.7.10";
    public static final String ACCEPTED_MC_VERSION = REQUIRED_MC_VERSION + "," + "1.7.2";
    public static final String FORGE_BASE = "10.13.2.";
    public static final String FORGE_BUILD = "1240";
    public static final String FORGE_VERSION = "[" + FORGE_BASE + FORGE_BUILD + "]";
    public static final String VERSION_BASE = "R0.2.0";
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
    public static final String dependencies = "required-after:Forge@" + FORGE_VERSION + ";required-after:CoFHCore;before:AdvancedFoods";

}
