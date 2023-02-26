package com.toonystank.dmeditor.sections.requirement;

import com.toonystank.dmeditor.sections.BaseSection;
import com.toonystank.dmeditor.sections.requirement.types.*;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class RequirementSection {

    public String path;

    public String name;
    public Requirements types;
    public Boolean isYes;
    public @Nullable List<String> success_commands;
    public @Nullable List<String> deny_commands;
    public @Nullable Boolean optional;
    public BaseSection baseSection;
    public List<Requirements> requirementTypes = new ArrayList<>();


    public RequirementSection(BaseSection baseSection, String name, BaseRequirementSection.BaseRequirement baseRequirement) {
        this.baseSection = baseSection;
        this.name = name;
        this.path = "items." + baseSection.sectionName + "." + baseRequirement.requirement + ".requirements.";
        this.requirementTypes.add(new HasExp(path, baseSection.configManager));
        this.requirementTypes.add(new HasItem(path, baseSection.configManager));
        this.requirementTypes.add(new HasMeta(path, baseSection.configManager));
        this.requirementTypes.add(new HasMoney(path, baseSection.configManager));
        this.requirementTypes.add(new HasPermission(path, baseSection.configManager));
        this.requirementTypes.add(new IsNear(path, baseSection.configManager));
        this.requirementTypes.add(new JavaScript(path, baseSection.configManager));
        this.requirementTypes.add(new StringContains(path, baseSection.configManager));
        this.requirementTypes.add(new StringEquals(path, baseSection.configManager));
        this.requirementTypes.add(new StringEqualsIgnoreCase(path, baseSection.configManager));
        this.requirementTypes.forEach(requirementTypes -> {
            if (baseSection.configManager.getConfig().contains(path + requirementTypes.type.yes)
                    || baseSection.configManager.getConfig().contains(path + requirementTypes.type.no)) {
                this.types = requirementTypes;
            }
        });
        this.success_commands = baseSection.configManager.getStringList(path + "success_commands");
        this.deny_commands = baseSection.configManager.getStringList(path + "deny_commands");
        this.optional = baseSection.configManager.getBoolean(path + "optional");
    }
    public RequirementSection setTypes(Requirements types, boolean isYes) {
        this.types = types;
        this.isYes = isYes;
        return this;
    }
    public RequirementSection setSuccess_commands(List<String> success_commands) {
        this.success_commands = success_commands;
        return this;
    }
    public RequirementSection setDeny_commands(List<String> deny_commands) {
        this.deny_commands = deny_commands;
        return this;
    }
    public RequirementSection setOptional(Boolean optional) {
        this.optional = optional;
        return this;
    }
    public void save() {
        if (isYes) {
            baseSection.configManager.set(path + types.type.yes, true);
        } else {
            baseSection.configManager.set(path + types.type.no, true);
        }
        types.save();
        baseSection.configManager.set(path + "success_commands", success_commands);
        baseSection.configManager.set(path + "deny_commands", deny_commands);
        baseSection.configManager.set(path + "optional", optional);
        baseSection.configManager.save();
    }


}
