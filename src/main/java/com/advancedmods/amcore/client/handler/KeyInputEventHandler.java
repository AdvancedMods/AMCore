package com.advancedmods.amcore.client.handler;

import com.advancedmods.amcore.AMCore;
import com.advancedmods.amcore.client.settings.Keybindings;
import com.advancedmods.amcore.common.reference.Key;
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
        AMCore.log.info(getPressedKeybinding());
    }

}
