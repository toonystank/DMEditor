package com.toonystank.dmeditor;

import com.toonystank.dmeditor.sections.BaseSection;
import com.toonystank.dmeditor.sections.CommandSection;
import com.toonystank.dmeditor.sections.requirement.BaseRequirementSection;
import com.toonystank.dmeditor.utils.ConfigManager;
import org.bukkit.plugin.Plugin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class DMFile extends ConfigManager {

    public DMEditor plugin;

    public Plugin deluxemenus;
    public String fileName;
    public String path;

    public String title;
    public BaseRequirementSection openRequirementSection;
    public CommandSection openCommandDenySection;
    public String inventory_type;
    public int size;
    public int update_interval;
    public List<String> open_commands = new ArrayList<>();

    public Map<String, BaseSection> sections = new HashMap<>();

    public DMFile(Plugin deluxemenus, DMEditor plugin, String pathWithFile, boolean construct) throws IOException {
        super(deluxemenus, pathWithFile);
        this.deluxemenus = deluxemenus;
        this.path = pathWithFile;
        this.fileName = pathWithFile.substring(pathWithFile.lastIndexOf("/") + 1);
        this.plugin = plugin;
    }

    public void loadConfig() {
        title = this.getString("title");
        openRequirementSection = new BaseRequirementSection(null);
        openCommandDenySection = new CommandSection(null, null);
        inventory_type = this.getString("inventory_type");
        size = this.getInt("size");
        update_interval = this.getInt("update_interval");
        open_commands = this.getStringList("open_commands");
        this.getConfig().getConfigurationSection("items").getKeys(false).forEach(sectionName -> sections.put(sectionName, new BaseSection(plugin, this, sectionName)));
    }
}
