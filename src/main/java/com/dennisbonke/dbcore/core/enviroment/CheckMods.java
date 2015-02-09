package com.dennisbonke.dbcore.core.enviroment;

import com.dennisbonke.dbcore.DBCore;
import com.dennisbonke.dbcore.core.DBCoreProps;
import cpw.mods.fml.common.Loader;

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

    public static void checkMCVersion(){

        if (Loader.MC_VERSION == DBCoreProps.MC_VERSION){
            DBCore.log.info("Using MC Version 1.7.10, proceed");
        }
        else {
            DBCore.log.error("Not using MC Version 1.7.10, abort");
        }

    }

}
