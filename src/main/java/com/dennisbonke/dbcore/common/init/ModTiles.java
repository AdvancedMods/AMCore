package com.dennisbonke.dbcore.common.init;

import com.dennisbonke.dbcore.common.tile.TileEntityEnergyStorageTest;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Dennisbonke on 9-2-2015.
 */
public class ModTiles {

    public static void init() {

        GameRegistry.registerTileEntity(TileEntityEnergyStorageTest.class, "TestStorage");

    }

}
