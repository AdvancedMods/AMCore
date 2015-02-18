package com.advancedmods.amcore.client.settings;

import com.advancedmods.amcore.common.reference.Names;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

/**
 * Created by Dennisbonke on 9-2-2015.
 */
public class Keybindings {

    public static KeyBinding charge = new KeyBinding(Names.Keys.CHARGE, Keyboard.KEY_C, Names.Keys.CATEGORY);
    public static KeyBinding release = new KeyBinding(Names.Keys.RELEASE, Keyboard.KEY_R, Names.Keys.CATEGORY);

    public static KeyBinding test = new KeyBinding(Names.Keys.TEST, Keyboard.KEY_P, Names.Keys.CATEGORY);
    public static KeyBinding dead = new KeyBinding(Names.Keys.DEAD, Keyboard.KEY_T, Names.Keys.CATEGORY);

}
