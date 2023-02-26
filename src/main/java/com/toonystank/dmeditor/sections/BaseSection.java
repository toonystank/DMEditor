package com.toonystank.dmeditor.sections;

import com.toonystank.dmeditor.DMEditor;
import com.toonystank.dmeditor.utils.ConfigManager;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BaseSection {

    private final DMEditor plugin;
    public ConfigManager configManager;
    public String sectionName;
    public String material;
    public @Nullable List<String> potionEffects = new ArrayList<>();
    public String displayName;
    public List<String> lore = new ArrayList<>();
    public List<Integer> slots = new ArrayList<>();
    public SectionOptions sectionOptions;
    public BaseCommandSection baseCommandSection;
    public boolean runTimeSection = false;

    public BaseSection(DMEditor plugin, ConfigManager configManager, String sectionName) {
        this.plugin = plugin;
        this.configManager = configManager;
        this.sectionName = sectionName;
        this.sectionOptions = new SectionOptions(this);
        this.baseCommandSection = new BaseCommandSection(this);
        loadConfig();
    }
    public BaseSection(DMEditor plugin, ConfigManager configManager, boolean runTimeSection) {
        this.plugin = plugin;
        this.configManager = configManager;
        this.runTimeSection = runTimeSection;
    }

    public BaseSection setSectionName(String sectionName) {
        this.sectionName = sectionName;
        return this;
    }
    public BaseSection setMaterial(String material) {
        this.material = material;
        return this;
    }
    public BaseSection setPotionEffects(List<String> potionEffects) {
        this.potionEffects = potionEffects;
        return this;
    }
    public BaseSection setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }
    public BaseSection setLore(List<String> lore) {
        this.lore = lore;
        return this;
    }
    public BaseSection setSlots(List<Integer> slots) {
        this.slots = slots;
        return this;
    }
    public BaseSection setSectionOptions(SectionOptions sectionOptions) {
        this.sectionOptions = sectionOptions;
        return this;
    }
    public BaseSection setBaseCommandSection(BaseCommandSection baseCommandSection) {
        this.baseCommandSection = baseCommandSection;
        return this;
    }

    public void save() {
        sectionOptions.save();
        baseCommandSection.save();
        saveConfig();
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

    public void saveConfig() {
        configManager.set("items." + sectionName + ".material", material);
        configManager.set("items." + sectionName + ".potionEffects", potionEffects);
        configManager.set("items." + sectionName + ".display_name", displayName);
        configManager.set("items." + sectionName + ".lore", lore);
        configManager.set("items." + sectionName + ".slots", slots);
        configManager.save();
    }
}
