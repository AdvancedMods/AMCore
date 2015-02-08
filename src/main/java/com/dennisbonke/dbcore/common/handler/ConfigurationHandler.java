package com.dennisbonke.dbcore.common.handler;

import com.dennisbonke.dbcore.DBCore;
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

    public static void init(File configFile)
    {
        // Create the configuration object from the given configuration file
        if (configuration == null)
        {
            DBCore.log.warn("Could not find configuration file. If this is the first time that you load this mod, this is perfectly normal");
            DBCore.log.warn("Creating and using default config");
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(DBCoreProps.modid))
        {
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        // Name, Category, Default value, Description
        configTest = configuration.getBoolean("configValue", Configuration.CATEGORY_GENERAL, true, "This is an example configuration value");

        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }


}
