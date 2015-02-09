package com.dennisbonke.dbcore;

import com.dennisbonke.dbcore.common.CommonProxy;
import com.dennisbonke.dbcore.common.handler.ConfigurationHandler;
import com.dennisbonke.dbcore.core.DBCoreProps;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Dennisbonke on 8-2-2015.
 */
@Mod(name = DBCoreProps.name, modid = DBCoreProps.modid, version = DBCoreProps.version, dependencies = DBCoreProps.dependencies, modLanguage = "java", canBeDeactivated = false)
public class DBCore {

    @Instance(DBCoreProps.name)
    public static DBCore instance;
    @SidedProxy(clientSide = DBCoreProps.clientproxy, serverSide = DBCoreProps.commonproxy)
    public static CommonProxy proxy;
    public static Logger log = LogManager.getLogger("DBCore");

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        log.info("Starting Pre-Init...");
        // Do PreInit stuff
        // Load the config
        log.info("Loading config");
        try {
            ConfigurationHandler.init(event.getSuggestedConfigurationFile());
            FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
            // NOTE: This is debug, kinda
            // Check configTest value
            if (ConfigurationHandler.configTest == true) {
                log.info("Test value is true");
            } else if (ConfigurationHandler.configTest == false) {
                log.info("Test value is false");
            } else {
                log.warn("Could not find test value, this is strange");
            }
        } catch (Exception e) {
            log.error("Could not load configuration file, this is a severe error and should be noted");
        }
        proxy.preInit();
        log.info("Pre-Init Finished");

    }

    @EventHandler
    public void Init(FMLInitializationEvent event) {

        log.info("Starting Init...");
        // Do Init stuff
        proxy.Init();
        log.info("Init Finished");

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        log.info("Starting Post-Init");
        // Do PostInit stuff
        proxy.postInit();
        log.info("Post-Init Finished");

    }

}
