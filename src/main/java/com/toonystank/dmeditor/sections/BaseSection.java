package com.toonystank.dmeditor.sections;

import com.toonystank.dmeditor.DMEditor;
import com.toonystank.dmeditor.utils.ConfigManager;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BaseSection {

    private DMEditor plugin;
    public ConfigManager configManager;
    public String sectionName;
    public String material;
    public @Nullable List<String> potionEffects = new ArrayList<>();
    public String displayName;
    public List<String> lore = new ArrayList<>();
    public List<Integer> slots = new ArrayList<>();
    public SectionOptions sectionOptions;

    public BaseSection(DMEditor plugin, ConfigManager configManager, String sectionName) {
        this.plugin = plugin;
        this.configManager = configManager;
        this.sectionName = sectionName;
        loadConfig();
    }
    
    public void loadConfig() {
        this.material = configManager.getString("items." + sectionName + ".material");
        this.potionEffects = configManager.getStringList("items." + sectionName + ".potionEffects");
        this.displayName = configManager.getString("items." + sectionName + ".display_name");
        plugin.getLogger().info("Loading " + sectionName + " with displayName " + displayName);
        this.lore = configManager.getStringList("items." + sectionName + ".lore");
        this.slots = configManager.getConfig().getIntegerList("items." + sectionName + ".slots");
        plugin.getLogger().info("Loading " + sectionName + " with slots " + slots);
    }
}
