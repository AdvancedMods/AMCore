package com.dennisbonke.dbcore;

import com.dennisbonke.dbcore.common.CommonProxy;
import com.dennisbonke.dbcore.core.DBCoreProps;
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
    public void preInit(FMLPreInitializationEvent event){

        log.info("Starting PreInit...");
        // Do PreInit stuff
        proxy.preInit();
        log.info("PreInit Finished");

    }

    @EventHandler
    public void Init(FMLInitializationEvent event){

        log.info("Starting Init...");
        // Do Init stuff
        proxy.Init();
        log.info("Init Finished");

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){

        log.info("Starting PostInit");
        // Do PostInit stuff
        proxy.postInit();
        log.info("PostInit Finished");

    }

}
