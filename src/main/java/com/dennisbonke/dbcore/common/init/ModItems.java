package com.dennisbonke.dbcore.common.init;

import com.dennisbonke.dbcore.DBCore;
import com.dennisbonke.dbcore.common.generic.ItemDBC;
import com.dennisbonke.dbcore.common.handler.ConfigurationHandler;
import com.dennisbonke.dbcore.common.items.ItemTest;
import com.dennisbonke.dbcore.core.DBCoreProps;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Dennisbonke on 8-2-2015.
 */
@GameRegistry.ObjectHolder(DBCoreProps.modid)
public class ModItems {

    public static ConfigurationHandler config;
    public static final ItemDBC testitem = new ItemTest();

    public static void init(){

        if (config.enableTestItem == true){
            DBCore.log.info("Item loaded");
            GameRegistry.registerItem(testitem, "testitem");
        }
        else {
            DBCore.log.info("Item not loaded");
        }

    }

}
