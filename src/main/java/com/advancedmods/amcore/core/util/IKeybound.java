package com.advancedmods.amcore.core.util;

import com.advancedmods.amcore.common.reference.Key;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

/**
 * Implement this on items / blocks that should have a key binding.
 * Created by Dennisbonke on 9-2-2015.
 *
 * @author Dennis Bonke
 * @since 0.2.0B1
 */
public interface IKeybound {

    public abstract void doKeyBindingAction(EntityPlayer entityPlayer, ItemStack itemStack, Key key);

}
