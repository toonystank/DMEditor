package com.toonystank.dmeditor.sections.requirement.types;

import com.toonystank.dmeditor.utils.ConfigManager;

public abstract class Requirements {

    public RequirementTypes type;
    public String path;
    public ConfigManager configManager;

    public Requirements(RequirementTypes type, String path, ConfigManager configManager) {
        this.type = type;
        this.path = path;
        this.configManager = configManager;
    }

    public abstract void save();


}
