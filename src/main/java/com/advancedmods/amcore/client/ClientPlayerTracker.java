package com.advancedmods.amcore.client;

import com.advancedmods.amcore.AMCore;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;

/**
 * Client Player tracker for AMCore
 * Created by Dennisbonke on 4-3-2015.
 *
 * @see com.advancedmods.amcore.common.CommonPlayerTracker
 * @author Dennis Bonke
 * @since 0.2.1B1
 */
public class ClientPlayerTracker {

    @SubscribeEvent
    public void onPlayerLoginEvent(PlayerLoggedInEvent event) {

        onPlayerLoginClient();

    }

    public void onPlayerLoginClient() {
        AMCore.log.debug("[CLIENT] Logging in....");
    }

    @SubscribeEvent
    public void onPlayerLogoutEvent(PlayerLoggedOutEvent event) {

    }

    @SubscribeEvent
    public void onPlayerDimChangedEvent(PlayerChangedDimensionEvent event) {

    }

    @SubscribeEvent
    public void onPlayerRespawnEvent(PlayerRespawnEvent event) {

    }

}
