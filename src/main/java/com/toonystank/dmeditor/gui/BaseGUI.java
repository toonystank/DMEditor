package com.toonystank.dmeditor.gui;

import dev.triumphteam.gui.components.GuiType;
import dev.triumphteam.gui.guis.Gui;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseGUI {

    public Map<Integer, ItemStack> slotMap = new HashMap<>();
    private String title;
    private Gui gui;

    public BaseGUI(String title) {
        gui = Gui.gui().title(Component.text(title)).type(GuiType.CHEST).rows(6).create();
    }

}
