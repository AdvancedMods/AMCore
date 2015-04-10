package com.advancedmods.amcore.common.achievement;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemPickupEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

/**
 * Created by Dennisbonke on 7-4-2015.
 *
 * @author Vazkii
 */
public final class AchievementTriggerer {

    @SubscribeEvent
    public void onItemPickedUp(ItemPickupEvent event) {
        ItemStack stack = event.pickedUp.getEntityItem();
        if (stack != null && stack.getItem() instanceof IPickupAchievement) {
            Achievement achievement = ((IPickupAchievement) stack.getItem()).getAchievementOnPickup(stack, event.player, event.pickedUp);
            if(achievement != null) {
                event.player.addStat(achievement, 1);
            }
        }
    }

    @SubscribeEvent
    public void onItemPickedUp(ItemCraftedEvent event) {
        if(event.crafting != null && event.crafting.getItem() instanceof ICraftAchievement) {
            Achievement achievement = ((ICraftAchievement) event.crafting.getItem()).getAchievementOnCraft(event.crafting, event.player, event.craftMatrix);
            if(achievement != null)
                event.player.addStat(achievement, 1);
        }
    }
}
