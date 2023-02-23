package com.toonystank.dmeditor.sections.requirement;

import com.toonystank.dmeditor.sections.BaseSection;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class BaseRequirementSection{

    public @NotNull BaseSection baseSection;

    public @Nullable List<BaseRequirement> requirementTypes = new ArrayList<>();
    public Map<BaseRequirement, RequirementSectionOptions> requirementSectionOptions = new HashMap<>();
    public @Nullable Map<BaseRequirement, List<RequirementSection>> requirementSections = new HashMap<>();

    public BaseRequirementSection(@NotNull BaseSection baseSection) {
        this.baseSection = baseSection;
        for (BaseRequirement baseRequirement : BaseRequirement.values()) {
            if (baseSection.configManager.getConfig().contains("items." + baseSection.sectionName + "." + baseRequirement.requirement)) {
                requirementTypes.add(baseRequirement);
            }
        }
        if (requirementTypes == null) return;
        for (BaseRequirement baseRequirement : requirementTypes) {
            requirementSectionOptions.put(baseRequirement, new RequirementSectionOptions(this, baseRequirement));
            List<RequirementSection> rsList = new ArrayList<>();
            baseSection.configManager.getConfig()
                    .getConfigurationSection("items." + baseSection.sectionName + "." + baseRequirement.requirement + ".requirements")
                    .getKeys(false)
                    .forEach(requirements -> {
                        RequirementSection rs = new RequirementSection(baseSection, requirements, baseRequirement);
                        rsList.add(rs);
                    });
            requirementSections.put(baseRequirement, rsList);
        }
    }

    public enum BaseRequirement {
        OPEN_REQUIREMENT("open_requirement"),
        VIEW_REQUIREMENT("view_requirement"),
        LEFT_CLICK_REQUIREMENT("left_click_requirement"),
        RIGHT_CLICK_REQUIREMENT("right_click_requirement"),
        SHIFT_LEFT_CLICK_REQUIREMENT("shift_left_click_requirement"),
        SHIFT_RIGHT_CLICK_REQUIREMENT("shift_right_click_requirement");

        public final String requirement;
        BaseRequirement(String requirement) {
            this.requirement = requirement;
        }
    }




}
