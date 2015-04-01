package com.advancedmods.amcore.common.handler;

import com.advancedmods.amcore.core.AMCoreProps;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Configuration Handler for AMCore
 * Created by Dennisbonke on 8-2-2015.
 *
 * @author Dennis Bonke
 * @since 0.2.0B1
 */
public class ConfigurationHandler {

    public static Configuration config;
    public static boolean enableUpdateNotice = true;
    public static boolean enableUpdateChecker = true;

    public static void init(File configFile) {
        // Create the configuration object from the given configuration file
        if (config == null) {
            config = new Configuration(configFile);
            loadConfig();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equalsIgnoreCase(AMCoreProps.modid)) {
            loadConfig();
        }
    }

    private static void loadConfig() {
        // Name, Category, Default value, Description
        enableUpdateNotice = config.getBoolean("enableUpdateNotice", "updates", true, "When false, will only show critical updates");
        enableUpdateChecker = config.getBoolean("enableUpdateChecker", "updates", true, "If false, will completely disable the update checker");

        if (config.hasChanged()) {
            config.save();
        }
    }


}
