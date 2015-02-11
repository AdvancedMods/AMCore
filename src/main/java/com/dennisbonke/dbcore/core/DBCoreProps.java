package com.dennisbonke.dbcore.core;

/**
 * Created by Dennisbonke on 8-2-2015.
 */
public class DBCoreProps {

    // Versioning
    public static final String REQUIRED_MC_VERSION = "1.7.10";
    public static final String ACCEPTED_MC_VERSION = REQUIRED_MC_VERSION + "," + "1.7.2";
    public static final String FORGE_BASE = "10.13.2.";
    public static final String FORGE_BUILD = "1240";
    public static final String FORGE_VERSION = "[" + FORGE_BASE + FORGE_BUILD + "]";
    public static final String VERSION_BASE = "0.0.1";
    public static final String VERSION_IDENTIFIER = "A2";

    // Updating stuff
    public static boolean enableUpdateNotice = true;

    // General Mod Stuff
    public static final String name = "DBCore";
    public static final String modid = "dbcore";
    public static final String version = REQUIRED_MC_VERSION + "-" + VERSION_BASE + "-" + VERSION_IDENTIFIER;
    public static final String clientproxy = "com.dennisbonke.dbcore.client.ClientProxy";
    public static final String commonproxy = "com.dennisbonke.dbcore.common.CommonProxy";
    public static final String dependencies = "required-after:Forge@" + FORGE_VERSION + ";required-after:CoFHCore;before:advancedfoods";

}
