package com.advancedmods.amcore.common;

import com.advancedmods.amcore.AMCore;
import com.advancedmods.amcore.core.environment.EnviromentChecks;
import com.advancedmods.amcore.core.util.EnumServerType;
import com.advancedmods.amcore.core.util.ServerChecker;
import com.mojang.authlib.GameProfile;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.MinecraftForge;

import java.util.UUID;

/**
 * Common Player tracker for AMCore
 * Created by Dennisbonke on 3-3-2015.
 *
 * @author Dennis Bonke
 * @since 0.2.0B1
 */
public class CommonPlayerTracker {

    public static Object ServerType;

    public CommonPlayerTracker()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onPlayerLoginEvent(PlayerLoggedInEvent event) {

        onPlayerLoginMain(event.player);

    }

    public void onPlayerLoginMain(EntityPlayer player) {

        onPlayerLoginChat(player);
        onPlayerLoginSideCheck(player);
        onPlayerLoginPlayerCheck(player);

    }

    public void onPlayerLoginChat(EntityPlayer player) {

        player.addChatComponentMessage(new ChatComponentText("Hello " + player.getDisplayName() + "!"));

    }

    public void onPlayerLoginSideCheck(EntityPlayer player) {

        if (!player.worldObj.isRemote) {

            AMCore.log.debug("Integrated Server");
            ServerType = EnumServerType.INTEGRATED;

        } else if (player.worldObj.isRemote) {

            AMCore.log.debug("Dedicated Server");
            ServerType = EnumServerType.DEDICATED;

        } else {

            AMCore.log.warn("Error checking Server Type!");
            ServerType = EnumServerType.UNKNOWN;

        }

    }

    public void onPlayerLoginPlayerCheck(EntityPlayer player) {

        try {
            AMCore.log.debug("[SERVER] " + player.getGameProfile().getName() + " is logging on.");
            if (EnviromentChecks.checkOnlineMode()) {
                if (player.getGameProfile().getId().equals(UUID.fromString("70bf2a19-271f-4adb-9ab1-b965fd7eb630"))) {
                    AMCore.log.info("Owner / Main dev Dennisbonke of Advanced Mods logged in!");
                    ChatComponentText msg = new ChatComponentText("All hail the AdvancedMods Owner / Main Dev!");
                    ChatStyle style = new ChatStyle();
                    style.setColor(EnumChatFormatting.GOLD);
                    style.setBold(true);
                    msg.setChatStyle(style);
                    player.addChatComponentMessage(msg);
                } else if (player.getGameProfile().getId().equals(UUID.fromString("9cd2a682-d1a1-4b3f-8bf2-162bf6b11852"))) {
                    AMCore.log.info("Owner / Artist Zandor300 of Advanced Mods logged in!");
                    ChatComponentText msg = new ChatComponentText("All hail the AdvancedMods main Artist!");
                    ChatStyle style = new ChatStyle();
                    style.setColor(EnumChatFormatting.GREEN);
                    style.setBold(true);
                    msg.setChatStyle(style);
                    player.addChatComponentMessage(msg);
                } else if(player.getGameProfile().getName().equals("poedermoeder0174")) {
                    AMCore.log.info("Main tester poedermoeder0174 of Advanced Mods logged in!");
                    ChatComponentText msg = new ChatComponentText("All hail the AdvancedMods main tester!");
                    ChatStyle style = new ChatStyle();
                    style.setColor(EnumChatFormatting.GREEN);
                    style.setBold(true);
                    msg.setChatStyle(style);
                    player.addChatComponentMessage(msg);
                } else {
                    AMCore.log.debug("Not specified");
                    AMCore.log.warn("Player" + player.getGameProfile().getName() + " with UUID:" + player.getGameProfile().getId());
                }
            } else {
                AMCore.log.warn("Offline mode detected, can not guarantee that the logged in user is really that user!");
            }
        } catch(Exception e) {
            AMCore.log.error("Errored");
            e.printStackTrace();
        }
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
