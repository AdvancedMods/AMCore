package com.advancedmods.amcore.core.environment;

import com.advancedmods.amcore.core.AMCoreProps;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Environment checker for AMCore
 * Created by Dennisbonke on 9-2-2015.
 *
 * @author Dennis Bonke
 * @since 0.2.0B1
 */
public class EnviromentChecks {

    public static boolean hasOptifine;
    protected static boolean isDeobf;
    public static Logger log = LogManager.getLogger("AM-Enviroment");
    public static final String issueURL = "https://github.com/AdvancedMods/AMCore/issues";

    public static void checkOptifine()
    {
        try {
            if ((FMLCommonHandler.instance().getSidedDelegate().getSide() == Side.CLIENT) && ((FMLClientHandler.instance().hasOptifine()) || (Loader.isModLoaded("optifine")))) {
                hasOptifine = true;
                log.warn("Optifine has been detected on your Minecraft installation, this can cause (rendering) issues");
            } else {
                hasOptifine = false;
            }
        } catch (Exception e) {
            log.warn("=============================WARNING!=============================");
            log.warn("Failed to check for optifine, assuming not installed");
            log.warn("Bug reports may not be complete!");
            log.warn("Please report this as a bug report with the stacktrace, the minecraft log, a mod list + version and if you have optifine installed to: " + issueURL);
            log.warn("=============================WARNING!=============================");
            e.printStackTrace();
            hasOptifine = false;
        }
    }

    public static void checkDeobf() {

        try {
            if (ObfUtil.isObf() == true) {
                isDeobf = true;
            } else {
                isDeobf = false;
            }
        } catch (Exception e) {
            log.error("=============================ERROR!=============================");
            log.error("Failed to check obfuscation, assuming we are in a normal enviroment.");
            log.error("This is a severe error and should be investigated ASAP!");
            log.error("Please report this as a bug report with the stacktrace, the minecraft log and a mod list + version to: " + issueURL);
            log.error("=============================ERROR!=============================");
            e.printStackTrace();
            isDeobf = false;
        }
    }

    public static void checkMCVersion() {

        if (Loader.MC_VERSION == AMCoreProps.MC_VERSION) {
            log.trace("Using MC Version 1.7.10, proceed");
        } else {
            FMLLog.log(Level.FATAL, "Not using MC version 1.7.10, aborting");
            System.gc();
            System.exit(-1);
        }
    }
}
