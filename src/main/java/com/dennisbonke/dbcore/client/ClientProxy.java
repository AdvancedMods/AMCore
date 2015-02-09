package com.dennisbonke.dbcore.client;

import com.dennisbonke.dbcore.client.settings.Keybindings;
import com.dennisbonke.dbcore.common.CommonProxy;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Created by Dennisbonke on 8-2-2015.
 */
@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    public static void registerKeyBindings()
    {
        ClientRegistry.registerKeyBinding(Keybindings.charge);
        ClientRegistry.registerKeyBinding(Keybindings.release);
    }

    public static void preInit() {

    }

    public static void Init() {

    }

    public static void postInit() {

    }

}
