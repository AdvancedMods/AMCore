package com.dennisbonke.dbcore.core;

/**
 * Created by Dennisbonke on 8-2-2015.
 */
public class DBCoreProps {

    // Versioning
    public static final String MC_VERSION = "1.7.10";
    public static final String FORGE_BASE = "10.13.2.";
    public static final String FORGE_BUILD = "1240";
    public static final String FORGE_VERSION = "[" + FORGE_BASE + FORGE_BUILD + "]";

    // Updating stuff
    public static boolean enableUpdateNotice = true;

    // General Mod Stuff
    public static final String name = "DBCore";
    public static final String modid = "dbcore";
    public static final String version = "0.0.1";
    public static final String clientproxy = "com.dennisbonke.dbcore.client.ClientProxy";
    public static final String commonproxy = "com.dennisbonke.dbcore.common.CommonProxy";
    public static final String dependencies = "required-after:Forge@" + FORGE_VERSION + ";after:CoFHCore";

}
