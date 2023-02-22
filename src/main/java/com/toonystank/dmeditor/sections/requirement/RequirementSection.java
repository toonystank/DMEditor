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
    public @Nullable List<String> success_commands;
    public @Nullable List<String> deny_commands;
    public @Nullable Boolean optional;
    public BaseSection baseSection;
    public List<Requirements> requirementTypes = new ArrayList<>();

    {
        this.requirementTypes.add(new HasExp());
        this.requirementTypes.add(new HasItem());
        this.requirementTypes.add(new HasMeta());
        this.requirementTypes.add(new HasMoney());
        this.requirementTypes.add(new HasPermission());
        this.requirementTypes.add(new IsNear());
        this.requirementTypes.add(new JavaScript());
        this.requirementTypes.add(new StringContains());
        this.requirementTypes.add(new StringEquals());
        this.requirementTypes.add(new StringEqualsIgnoreCase());
    }

    public RequirementSection(BaseSection baseSection, String name, BaseRequirementSection.BaseRequirement baseRequirement) {
        this.baseSection = baseSection;
        this.name = name;
        this.path = "items." + baseSection.sectionName + "." + baseRequirement.requirement + ".requirements.";
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


}
