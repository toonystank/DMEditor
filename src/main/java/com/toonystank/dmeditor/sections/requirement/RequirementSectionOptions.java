package com.toonystank.dmeditor.sections.requirement;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RequirementSectionOptions{
    public @Nullable Integer minimum_requirements;
    public @Nullable Boolean stop_at_success;
    public @Nullable List<String> deny_commands;

    public RequirementSectionOptions(BaseRequirementSection baseRequirementSection, BaseRequirementSection.BaseRequirement baseRequirement) {
        this.minimum_requirements = baseRequirementSection.baseSection.configManager.getInt("items." + baseRequirementSection.baseSection.sectionName + "." +baseRequirement.requirement + ".minimum_requirements");
        this.stop_at_success = baseRequirementSection.baseSection.configManager.getBoolean("items." + baseRequirementSection.baseSection.sectionName + "." +baseRequirement.requirement + ".stop_at_success");
        this.deny_commands = baseRequirementSection.baseSection.configManager.getStringList("items." + baseRequirementSection.baseSection.sectionName + "." +baseRequirement.requirement + ".deny_commands");
    }

}
