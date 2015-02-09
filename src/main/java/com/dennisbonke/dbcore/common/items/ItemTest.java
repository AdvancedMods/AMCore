package com.dennisbonke.dbcore.common.items;

import com.dennisbonke.dbcore.common.generic.ItemDBC;
import com.dennisbonke.dbcore.common.reference.Key;
import com.dennisbonke.dbcore.util.IKeybound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

/**
 * Created by Dennisbonke on 8-2-2015.
 */
public class ItemTest extends ItemDBC implements IKeybound {

    public ItemTest() {
        super();
        this.setUnlocalizedName("testitem");
    }

    @Override
    public void doKeyBindingAction(EntityPlayer entityPlayer, ItemStack itemStack, Key key) {

        if (key == Key.DEAD){
            entityPlayer.setDead();
        }

    }
}
