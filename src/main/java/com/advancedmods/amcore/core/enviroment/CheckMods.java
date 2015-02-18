package com.advancedmods.amcore.core.enviroment;

import com.advancedmods.amcore.AMCore;
import com.advancedmods.amcore.core.AMCoreProps;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.WrongMinecraftVersionException;

/**
 * Created by Dennisbonke on 9-2-2015.
 */
public class CheckMods {

    public static void checkMods() {

        if (Loader.isModLoaded("CoFHCore")){
            AMCore.log.info("CoFHCore found, prepare for awesomeness");
        }

        if (Loader.isModLoaded("Thermal Expansion")){

        }

        if (Loader.isModLoaded("IC2")){

        }

    }

    public static void checkMCVersion() throws WrongMinecraftVersionException {

        try {
            if (Loader.MC_VERSION == AMCoreProps.ACCEPTED_MC_VERSION) {
                AMCore.log.info("Using MC Version 1.7.10 or 1.7.2, proceed");
            }
        } catch (WrongMinecraftVersionException e) {
            if (Loader.MC_VERSION != AMCoreProps.ACCEPTED_MC_VERSION){
                AMCore.log.fatal("Not using MC version 1.7.10 or 1.7.2, aborting");
            }
        }

    }

}
