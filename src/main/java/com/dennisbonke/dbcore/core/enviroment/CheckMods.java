package com.dennisbonke.dbcore.core.enviroment;

import com.dennisbonke.dbcore.DBCore;
import com.dennisbonke.dbcore.core.DBCoreProps;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.WrongMinecraftVersionException;

/**
 * Created by Dennisbonke on 9-2-2015.
 */
public class CheckMods {

    public static void checkMods() {

        if (Loader.isModLoaded("CoFHCore")){
            DBCore.log.info("CoFHCore found, prepare for awesomeness");
        }
        else if (Loader.isModLoaded("Thermal Expansion")){

        }
        else if (Loader.isModLoaded("IC2")){

        }

    }

    public static void checkMCVersion() throws WrongMinecraftVersionException {

        try {
            if (Loader.MC_VERSION == DBCoreProps.MC_VERSION) {
                DBCore.log.info("Using MC Version 1.7.10, proceed");
            } else if (Loader.MC_VERSION == "1.7.2") {
                DBCore.log.error("Not using MC Version 1.7.10, using 1.7.2, this might work");
            }
        } catch (WrongMinecraftVersionException e) {
            if (Loader.MC_VERSION != DBCoreProps.MC_VERSION && Loader.MC_VERSION != "1.7.2"){
                DBCore.log.fatal("Not using MC version 1.7.10 or 1.7.2, aborting");
            }
        }

    }

}
