package com.dennisbonke.dbcore.client.handler;

import com.dennisbonke.dbcore.DBCore;
import com.dennisbonke.dbcore.client.settings.Keybindings;
import com.dennisbonke.dbcore.common.reference.Key;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

/**
 * Created by Dennisbonke on 9-2-2015.
 */
public class KeyInputEventHandler {

    private static Key getPressedKeybinding()
    {
        if (Keybindings.charge.isPressed())
        {
            return Key.CHARGE;
        }
        else if (Keybindings.release.isPressed())
        {
            return Key.RELEASE;
        }

        return Key.UNKNOWN;
    }

    @SubscribeEvent
    public void handleKeyInputEvent(InputEvent.KeyInputEvent event)
    {
        DBCore.log.info(getPressedKeybinding());
    }

}
