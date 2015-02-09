package com.dennisbonke.dbcore.common.blocks;

import cofh.api.block.IBlockInfo;
import cofh.api.block.IDismantleable;
import com.dennisbonke.dbcore.common.tile.TileEntityEnergyStorageTest;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dennisbonke on 9-2-2015.
 */
public class EnergyStorageBlockTest extends BlockContainer implements IBlockInfo, IDismantleable {

    public EnergyStorageBlockTest() {
        super(Material.iron);
        this.setBlockName("energytest");
        this.setBlockTextureName("energytest");
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityEnergyStorageTest();
    }

    @Override
    public void getBlockInfo(IBlockAccess iBlockAccess, int i, int i1, int i2, ForgeDirection forgeDirection, EntityPlayer entityPlayer, List<IChatComponent> list, boolean b) {

    }

    @Override
    public ArrayList<ItemStack> dismantleBlock(EntityPlayer entityPlayer, World world, int i, int i1, int i2, boolean b) {
        return null;
    }

    @Override
    public boolean canDismantle(EntityPlayer entityPlayer, World world, int i, int i1, int i2) {
        return false;
    }
}
