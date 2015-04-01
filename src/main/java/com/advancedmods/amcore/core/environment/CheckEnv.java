package com.advancedmods.amcore.core.environment;

import com.advancedmods.amcore.AMCore;
import com.advancedmods.amcore.core.AMCoreProps;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;

/**
 * Environment checker for AMCore
 * Created by Dennisbonke on 9-2-2015.
 *
 * @author Dennis Bonke
 * @since 0.2.0B1
 */
public class CheckEnv {

    public static void checkMCVersion() {

        if (Loader.MC_VERSION == AMCoreProps.REQUIRED_MC_VERSION) {
            AMCore.log.trace("Using MC Version 1.7.10, proceed");
        } else {
            FMLLog.severe("Not using MC version 1.7.10, aborting");
            System.gc();
            System.exit(-1);
        }
    }
}
