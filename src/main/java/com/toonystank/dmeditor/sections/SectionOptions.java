package com.toonystank.dmeditor.sections;

import org.jetbrains.annotations.Nullable;
public class SectionOptions extends SectionItemOptions {
    public @Nullable Integer priority;
    public @Nullable Boolean update;
    private final BaseSection baseSection;

    public SectionOptions(BaseSection baseSection) {
        super(baseSection);
        this.baseSection = baseSection;
        if (!baseSection.runTimeSection) {
            this.priority = baseSection.configManager.getInt("items." + baseSection.sectionName + ".priority");
            this.update = baseSection.configManager.getBoolean("items." + baseSection.sectionName + ".update");
        }
    }
    public SectionOptions setPriority(Integer priority) {
        this.priority = priority;
        return this;
    }
    public SectionOptions setUpdate(Boolean update) {
        this.update = update;
        return this;
    }
    public SectionOptions Construct() {
        baseSection.configManager.set("items." + baseSection.sectionName + ".priority", priority);
        baseSection.configManager.set("items." + baseSection.sectionName + ".update", update);
        baseSection.configManager.save();
        return this;
    }
}
