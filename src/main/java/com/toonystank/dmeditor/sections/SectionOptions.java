package com.toonystank.dmeditor.sections;

import com.toonystank.dmeditor.utils.ConfigManager;
import org.jetbrains.annotations.Nullable;
public class SectionOptions extends SectionItemOptions {
    public @Nullable Integer priority;
    public @Nullable Boolean update;

    public SectionOptions(ConfigManager configManager, String sectionName) {
        super(configManager,sectionName);
        this.priority = configManager.getInt("items." + sectionName + ".priority");
        this.update = configManager.getBoolean("items." + sectionName + ".update");
    }
}
