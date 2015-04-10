package com.advancedmods.amcore.common.achievement;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

/**
 * Created by Dennisbonke on 10-4-2015.
 *
 * @author Vazkii
 */
public interface IPickupAchievement {

    public Achievement getAchievementOnPickup(ItemStack stack, EntityPlayer player, EntityItem item);

}
