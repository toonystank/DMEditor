package com.toonystank.dmeditor.utils;

import com.toonystank.dmeditor.DMEditor;
import com.toonystank.dmeditor.sections.BaseSection;
import com.toonystank.dmeditor.utils.ConfigManager;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DMConfig extends ConfigManager {

    private final DMEditor plugin;
    private Plugin deluxeMenus;
    private Set<String> guiMenus = new HashSet<>();
    private Map<String,ConfigManager> guiFiles = new HashMap<>();
    private Map<String, BaseSection> guiSections = new HashMap<>();
    public DMConfig(DMEditor plugin) throws IOException {
        super(plugin.getServer().getPluginManager().getPlugin("DeluxeMenus"), "config.yml", false, false);
        this.plugin = plugin;
        this.deluxeMenus = plugin.getServer().getPluginManager().getPlugin("DeluxeMenus");
        plugin.getServer().getScheduler().runTaskLater(plugin, () -> {
            plugin.getLogger().info("Loading DeluxeMenus config");
            plugin.getLogger().info("plugin "+ deluxeMenus.getDataFolder().getPath());
            plugin.getLogger().info(this.getConfig().getCurrentPath());
            loadConfig();
        }, 40);
    }

    public void loadConfig() {
        guiMenus = this.getConfig().getConfigurationSection("gui_menus").getKeys(false);
        guiMenus.forEach(menu -> {
            String file = this.getString("gui_menus." + menu + ".file");
            plugin.getLogger().info("Loading GUI " + file);
            ConfigManager guiConfig;
            try {
                guiConfig = new ConfigManager(deluxeMenus,"gui_menus" + File.separator + file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            guiFiles.put(menu, guiConfig);
        });
        plugin.getServer().getScheduler().runTaskLater(plugin, this::loadSections, 40);
    }
    public void loadSections() {
        guiFiles.forEach((menu, guiConfig) -> {
            Set<String> sections = guiConfig.getConfig().getConfigurationSection("items").getKeys(false);
            plugin.getLogger().info("Loading " + sections.size() + " sections for " + menu);
            sections.forEach(section -> {
                BaseSection guiSection = new BaseSection(plugin,guiConfig, section);
                guiSections.put(section, guiSection);
            });
        });
    }

}
