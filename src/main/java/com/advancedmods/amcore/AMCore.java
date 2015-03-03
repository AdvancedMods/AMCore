package com.advancedmods.amcore;

import com.advancedmods.amcore.common.CommonProxy;
import com.advancedmods.amcore.common.handler.ConfigurationHandler;
import com.advancedmods.amcore.core.AMCoreProps;
import com.advancedmods.amcore.core.environment.CheckEnv;
import com.advancedmods.amcore.core.mod.BaseMod;
import com.advancedmods.amcore.core.mod.updater.UpdateManager;
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
 * Main Mod class for AMCore
 * Created by Dennisbonke on 8-2-2015.
 *
 * @author Dennis Bonke
 * @since 0.2.0B1
 */
@Mod(name = AMCoreProps.name, modid = AMCoreProps.modid, version = AMCoreProps.version, dependencies = AMCoreProps.dependencies, modLanguage = "java", canBeDeactivated = false, acceptedMinecraftVersions = AMCoreProps.REQUIRED_MC_VERSION)
public class AMCore extends BaseMod {

    @Instance(AMCoreProps.name)
    public static AMCore instance;
    @SidedProxy(clientSide = AMCoreProps.clientproxy, serverSide = AMCoreProps.commonproxy)
    public static CommonProxy proxy;
    public static Logger log = LogManager.getLogger("AMCore");
    public static final String releaseURL = "https://raw.github.com/AdvancedMods/AMCore/master/VERSION";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        log.info("Starting AMCore version: " + AMCoreProps.version + "...");
        log.info("Starting Pre-Init...");
        log.debug("Checking MC version...");
        CheckEnv.checkMCVersion();
        // Do PreInit stuff
        // Load the config
        log.info("Loading config...");
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        try {
            // NOTE: This is debug, kinda
            // Check configTest value
            if (ConfigurationHandler.configTest == true) {
                log.debug("Test value is true");
            } else if (ConfigurationHandler.configTest == false) {
                log.debug("Test value is false");
            } else {
                log.warn("Could not find test value, this is strange");
            }
        } catch (Exception e) {
            log.error("Could not load configuration file, this is a severe error and should be noted");
        }
        log.info("Config loaded");
        // Loading mod stuff
        // Checking for updated version
        log.info("Starting Update Checker for AMCore...");
        UpdateManager.registerUpdater(new UpdateManager(this, "https://raw.github.com/AdvancedMods/AMCore/master/VERSION", null));
        log.info("Update Checker for AMCore started");
        log.info("Pre-Init Finished");

    }

    @EventHandler
    public void Init(FMLInitializationEvent event) {

        log.info("Starting Init...");
        // Do Init stuff
        log.info("Init Finished");
        log.info("Mod loaded");

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        log.info("Starting Post-Init...");
        // Do PostInit stuff
        log.info("Post-Init Finished");

    }

    @Override
    public String getModId() {
        return AMCoreProps.modid;
    }

    @Override
    public String getModName() {
        return AMCoreProps.name;
    }

    @Override
    public String getModVersion() {
        return AMCoreProps.version;
    }
}
