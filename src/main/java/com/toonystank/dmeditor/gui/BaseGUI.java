package com.toonystank.dmeditor.gui;

import com.toonystank.dmeditor.utils.ConfigManager;
import dev.triumphteam.gui.components.GuiType;
import dev.triumphteam.gui.guis.Gui;
import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class BaseGUI {

    public Map<Integer, ItemStack> slotMap = new HashMap<>();
    private final String title;
    private final Gui gui;
    private @Nullable ConfigManager guiFile;
    private @Nullable String sectionName;

    public BaseGUI(String title) {
        this.title = title;
        gui = Gui.gui().title(Component.text(title)).type(GuiType.CHEST).rows(6).create();
    }

}
