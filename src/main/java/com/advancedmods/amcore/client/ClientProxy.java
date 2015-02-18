package com.advancedmods.amcore.client;

import com.advancedmods.amcore.client.settings.Keybindings;
import com.advancedmods.amcore.common.CommonProxy;
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

}
