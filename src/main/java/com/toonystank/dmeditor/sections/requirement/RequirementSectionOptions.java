package com.toonystank.dmeditor.sections.requirement;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RequirementSectionOptions{

    private final BaseRequirementSection baseRequirementSection;
    private final BaseRequirementSection.BaseRequirement baseRequirement;
    public @Nullable Integer minimum_requirements;
    public @Nullable Boolean stop_at_success;
    public @Nullable List<String> deny_commands;

    public RequirementSectionOptions(BaseRequirementSection baseRequirementSection, BaseRequirementSection.BaseRequirement baseRequirement) {
        this.baseRequirementSection = baseRequirementSection;
        this.baseRequirement = baseRequirement;
        this.minimum_requirements = baseRequirementSection.baseSection.configManager.getInt("items." + baseRequirementSection.baseSection.sectionName + "." +baseRequirement.requirement + ".minimum_requirements");
        this.stop_at_success = baseRequirementSection.baseSection.configManager.getBoolean("items." + baseRequirementSection.baseSection.sectionName + "." +baseRequirement.requirement + ".stop_at_success");
        this.deny_commands = baseRequirementSection.baseSection.configManager.getStringList("items." + baseRequirementSection.baseSection.sectionName + "." +baseRequirement.requirement + ".deny_commands");
    }

    public RequirementSectionOptions setMinimum_requirements(Integer minimum_requirements) {
        this.minimum_requirements = minimum_requirements;
        return this;
    }
    public RequirementSectionOptions setStop_at_success(Boolean stop_at_success) {
        this.stop_at_success = stop_at_success;
        return this;
    }
    public RequirementSectionOptions setDeny_commands(List<String> deny_commands) {
        this.deny_commands = deny_commands;
        return this;
    }
    public void save() {
        baseRequirementSection.baseSection.configManager.set("items." + baseRequirementSection.baseSection.sectionName + "." + baseRequirement.requirement + ".minimum_requirements", minimum_requirements);
        baseRequirementSection.baseSection.configManager.set("items." + baseRequirementSection.baseSection.sectionName + "." +baseRequirement.requirement + ".stop_at_success", stop_at_success);
        baseRequirementSection.baseSection.configManager.set("items." + baseRequirementSection.baseSection.sectionName + "." +baseRequirement.requirement + ".deny_commands", deny_commands);
        baseRequirementSection.baseSection.configManager.save();
    }
}
