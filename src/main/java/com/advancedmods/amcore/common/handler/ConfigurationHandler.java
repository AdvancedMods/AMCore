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

    public static Configuration configuration;
    public static boolean configTest = true;
    public static boolean enableTestItem = true;
    public static boolean enableTestBlock = true;

    public static void init(File configFile) {
        // Create the configuration object from the given configuration file
        if (configuration == null) {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equalsIgnoreCase(AMCoreProps.modid)) {
            loadConfiguration();
        }
    }

    private static void loadConfiguration() {
        // Name, Category, Default value, Description
        configTest = configuration.getBoolean("configTest", Configuration.CATEGORY_GENERAL, true, "Test Value");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }


}
