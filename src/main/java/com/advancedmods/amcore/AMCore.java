package com.advancedmods.amcore;

import com.advancedmods.amcore.common.CommonPlayerTracker;
import com.advancedmods.amcore.common.CommonProxy;
import com.advancedmods.amcore.common.handler.ConfigurationHandler;
import com.advancedmods.amcore.core.AMCoreProps;
import com.advancedmods.amcore.core.environment.EnviromentChecks;
import com.advancedmods.amcore.core.environment.IMCHandler;
import com.advancedmods.amcore.core.mod.BaseMod;
import com.advancedmods.amcore.core.mod.updater.UpdateManager;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
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
@Mod(name = AMCoreProps.name, modid = AMCoreProps.modid, version = AMCoreProps.version, dependencies = AMCoreProps.dependencies, modLanguage = "java", canBeDeactivated = false, acceptedMinecraftVersions = AMCoreProps.MC_VERSION)
public class AMCore extends BaseMod {

    @Instance(AMCoreProps.name)
    public static AMCore instance;
    @SidedProxy(clientSide = AMCoreProps.clientproxy, serverSide = AMCoreProps.commonproxy)
    public static CommonProxy proxy;
    public static Logger log = LogManager.getLogger("AMCore");
    public static final String issueURL = "https://github.com/AdvancedMods/AMCore/issues";
    public static final String updateURL = "https://raw.github.com/AdvancedMods/AMCore/master/VERSION";
    public static final String downloadURL = "http://ci.zsinfo.nl/job/AMCore/lastSuccessfulBuild/";
    public static ConfigurationHandler config;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        log.info("Starting AMCore version: " + AMCoreProps.version + "...");
        log.info("Entering Pre-Init...");
        // MC Version check
        log.debug("Checking MC version...");
        EnviromentChecks.checkMCVersion();
        // Optifine check
        try {
            EnviromentChecks.log.info("Checking if optifine is installed...");
            EnviromentChecks.checkOptifine();
            EnviromentChecks.log.info("Check complete");
        } catch (Exception e) {
            EnviromentChecks.log.warn("=============================WARNING!=============================");
            EnviromentChecks.log.warn("Failed to check for optifine, assuming not installed");
            EnviromentChecks.log.warn("Bug reports may not be complete!");
            EnviromentChecks.log.warn("Please report this as a bug report with the stacktrace, the minecraft log, a mod list + version and if you have optifine installed to: " + issueURL);
            EnviromentChecks.log.warn("=============================WARNING!=============================");
            e.printStackTrace();
        }
        // Obfuscation check
        try {
            EnviromentChecks.log.info("Checking if we are in a deobfuscated environment...");
            EnviromentChecks.checkDeobf();
            EnviromentChecks.log.info("Check complete");
        } catch (Exception e) {
            EnviromentChecks.log.error("=============================ERROR!=============================");
            EnviromentChecks.log.error("Failed to check obfuscation, assuming we are in a normal enviroment.");
            EnviromentChecks.log.error("This is a severe error and should be investigated ASAP!");
            EnviromentChecks.log.error("Please report this as a bug report with the stacktrace, the minecraft log and a mod list + version to: " + issueURL);
            EnviromentChecks.log.error("=============================ERROR!=============================");
            e.printStackTrace();
        }
        // Do PreInit stuff
        // Load the config
        try {
            log.info("Loading config...");
            ConfigurationHandler.init(event.getSuggestedConfigurationFile());
            FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
            log.info("Config loaded");
        } catch (Exception e) {
            log.error("=============================ERROR!=============================");
            log.error("Failed to load the config, printing stacktrace and using default values...");
            log.error("Please report this as a bug report with the stacktrace, the minecraft log and a mod list + version to: " + issueURL);
            log.error("=============================ERROR!=============================");
            e.printStackTrace();
        }
        // Loading mod stuff
        // Checking for updated version
        if (config.enableUpdateChecker) {
            try {
                log.info("Starting Update Checker for AMCore...");
                UpdateManager.registerUpdater(new UpdateManager(this, updateURL, downloadURL));
                log.info("Update Checker for AMCore started");
            } catch (Exception e) {
                log.error("=============================ERROR!=============================");
                log.error("Failed to start the update checker, printing stacktrace...");
                log.error("Please report this as a bug report with the stacktrace, the minecraft log and a mod list + version to: " + issueURL);
                log.error("=============================ERROR!=============================");
                e.printStackTrace();
            }
        } else if (!config.enableUpdateChecker) {
            log.info("Update checker disabled");
        } else {
            log.error("Could not read config value, ignoring...");
            try {
                UpdateManager.registerUpdater(new UpdateManager(this, updateURL, downloadURL));
            } catch (Exception e) {
                log.error("=============================ERROR!=============================");
                log.error("Failed to start the update checker, printing stacktrace...");
                log.error("Please report this as a bug report with the stacktrace, the minecraft log and a mod list + version to: " + issueURL);
                log.error("=============================ERROR!=============================");
                e.printStackTrace();
            }
        }
        try {
            log.info("Registering trackers...");
            FMLCommonHandler.instance().bus().register(new CommonPlayerTracker());
            proxy.loadTracker();
            log.info("Trackers Registered");
        } catch (Exception e) {
            log.error("=============================ERROR!=============================");
            log.error("Failed to register the trackers, printing stacktrace...");
            log.error("Please report this as a bug report with the stacktrace, the minecraft log and a mod list + version to: " + issueURL);
            log.error("=============================ERROR!=============================");
            e.printStackTrace();
        }
        log.info("Pre-Init Finished");

    }

    @EventHandler
    public void Init(FMLInitializationEvent event) {

        log.info("Entering Init...");
        // Do Init stuff
        log.info("Init Finished");
        log.info("Mod loaded");

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        log.info("Entering Post-Init...");
        // Do PostInit stuff
        log.info("Post-Init Finished");

    }

    @EventHandler
    public void handleIMC(FMLInterModComms.IMCEvent event) {

        // IMCHandler
        try {
            log.info("Processing IMC messages...");
            IMCHandler.processIMC(event.getMessages());
            log.info("IMC Messages processed.");
        } catch (Exception e) {
            log.error("=============================ERROR!=============================");
            log.error("Failed to process IMC Messages, printing stacktrace...");
            log.error("Please report this as a bug report with the stacktrace, the minecraft log and a mod list + version to: " + issueURL);
            log.error("=============================ERROR!=============================");
            e.printStackTrace();
        }
    }

    @EventHandler
    public void loadComplete(FMLLoadCompleteEvent event) {

        // Fetching runtime messages
        try {
            log.info("Fetching runtime IMC messages...");
            IMCHandler.processIMC(FMLInterModComms.fetchRuntimeMessages(this));
            log.info("Fetched runtime IMC messages.");
        } catch (Exception e) {
            log.error("=============================ERROR!=============================");
            log.error("Failed to fetch IMC Runtime messages, printing stacktrace...");
            log.error("Please report this as a bug report with the stacktrace, the minecraft log and a mod list + version to: " + issueURL);
            log.error("=============================ERROR!=============================");
            e.printStackTrace();
        }
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
