package com.dennisbonke.dbcore.common;

import com.dennisbonke.dbcore.common.init.ModBlocks;
import com.dennisbonke.dbcore.common.init.ModItems;

/**
 * Created by Dennisbonke on 8-2-2015.
 */
public class CommonProxy {

    public static void preInit(){

        ModItems.init();
        ModBlocks.init();
    }

    public static void Init(){

    }

    public static void postInit(){

    }

}
