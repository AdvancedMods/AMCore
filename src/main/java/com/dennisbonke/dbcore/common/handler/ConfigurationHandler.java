package com.dennisbonke.dbcore.common.handler;

import com.dennisbonke.dbcore.core.DBCoreProps;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by Dennisbonke on 8-2-2015.
 */
public class ConfigurationHandler {

    public static Configuration configuration;
    public static boolean configTest = true;
    public static boolean enableTestItem = true;
    public static boolean enableTestBlock = true;
    //public static boolean niceStuff = true;

    public static void init(File configFile) {
        // Create the configuration object from the given configuration file
        if (configuration == null) {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equalsIgnoreCase(DBCoreProps.modid)) {
            loadConfiguration();
        }
    }

    private static void loadConfiguration() {
        // Name, Category, Default value, Description
        configTest = configuration.getBoolean("configTest", Configuration.CATEGORY_GENERAL, true, "This is an example configuration value");
        enableTestItem = configuration.getBoolean("enableTestItem", Configuration.CATEGORY_GENERAL, true, "Enable Test Item");
        enableTestBlock = configuration.getBoolean("enableTestBlock", Configuration.CATEGORY_GENERAL, true, "Enable Test Block");
        //niceStuff = configuration.getBoolean("niceStuff", Configuration.CATEGORY_GENERAL, true, "You like it!");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }


}
