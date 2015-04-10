package com.advancedmods.amcore.core.util;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.server.FMLServerHandler;
import net.minecraft.client.Minecraft;

/**
 * Checks the server type
 * Created by Dennisbonke on 3-3-2015.
 *
 * @author Dennis Bonke
 * @since 0.2.0B1
 */
public class ServerChecker {

    public static Object ServerType;

    public void CheckServerType() {

        if (Minecraft.getMinecraft().isSingleplayer()) {

            ServerType = EnumServerType.INTEGRATED;

        } else if (!FMLClientHandler.instance().getServer().isDedicatedServer()) {

            ServerType = EnumServerType.INTEGRATED;

        } else if (!FMLServerHandler.instance().getServer().isDedicatedServer()) {

            ServerType = EnumServerType.INTEGRATED;

        } else if (FMLServerHandler.instance().getServer().isDedicatedServer()) {

            ServerType = EnumServerType.DEDICATED;

        } else if (!Minecraft.getMinecraft().isSingleplayer()) {

            ServerType = EnumServerType.DEDICATED;

        } else if (FMLClientHandler.instance().getServer().isDedicatedServer()) {

            ServerType = EnumServerType.DEDICATED;

        } else {

            ServerType = EnumServerType.UNKNOWN;
            FMLLog.bigWarning("Could not determine which server you are on!");

        }

    }

}
