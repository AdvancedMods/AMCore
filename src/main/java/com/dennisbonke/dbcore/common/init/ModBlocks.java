package com.dennisbonke.dbcore.common.init;

import com.dennisbonke.dbcore.DBCore;
import com.dennisbonke.dbcore.common.blocks.BlockTest;
import com.dennisbonke.dbcore.common.generic.BlockDBC;
import com.dennisbonke.dbcore.common.handler.ConfigurationHandler;
import com.dennisbonke.dbcore.core.DBCoreProps;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Dennisbonke on 9-2-2015.
 */
@GameRegistry.ObjectHolder(DBCoreProps.modid)
public class ModBlocks {

    public static ConfigurationHandler config;
    public static final BlockDBC testblock = new BlockTest();

    public static void init() {

        if (config.enableTestBlock == true) {
            GameRegistry.registerBlock(testblock, "test");
            DBCore.log.info("Block loaded");
        } else {
            DBCore.log.info("Block not loaded");
        }
    }

}
