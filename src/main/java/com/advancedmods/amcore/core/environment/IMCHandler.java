package com.advancedmods.amcore.core.environment;

import cpw.mods.fml.common.event.FMLInterModComms;

import java.util.List;

/**
 * Created by Dennisbonke on 15-4-2015.
 */
public final class IMCHandler {

    public static void processIMC(List<FMLInterModComms.IMCMessage> messages)
    {
        for (FMLInterModComms.IMCMessage message : messages)
        {
            String type = message.key;
            if ((type == null) || (type.isEmpty())) {}
        }
    }

}
