package com.advancedmods.amcore.common.achievement;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

/**
 * Created by Dennisbonke on 10-4-2015.
 *
 * @author Vazkii
 */
public interface ICraftAchievement {

    public Achievement getAchievementOnCraft(ItemStack stack, EntityPlayer player, IInventory matrix);

}
