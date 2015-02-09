package com.dennisbonke.dbcore.common;

import com.dennisbonke.dbcore.common.init.ModBlocks;
import com.dennisbonke.dbcore.common.init.ModItems;
import com.dennisbonke.dbcore.core.enviroment.CheckMods;

/**
 * Created by Dennisbonke on 8-2-2015.
 */
public class CommonProxy {

    public static void preInit() {

        CheckMods.checkMods();
        ModItems.init();
        ModBlocks.init();
    }

    public static void Init() {

    }

    public static void postInit() {

    }

}
