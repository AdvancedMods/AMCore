package com.advancedmods.amcore.util;

import com.advancedmods.amcore.common.reference.Key;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

/**
 * Created by Dennisbonke on 9-2-2015.
 */
public interface IKeybound {

    public abstract void doKeyBindingAction(EntityPlayer entityPlayer, ItemStack itemStack, Key key);

}
