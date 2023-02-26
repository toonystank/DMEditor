package com.toonystank.dmeditor.sections.requirement;

import com.toonystank.dmeditor.sections.BaseSection;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class BaseRequirementSection{

    public BaseSection baseSection;

    public  List<BaseRequirement> requirementTypes = new ArrayList<>();
    public Map<BaseRequirement, RequirementSectionOptions> requirementSectionOptions = new HashMap<>();
    public @Nullable Map<BaseRequirement, List<RequirementSection>> requirementSections = new HashMap<>();

    public BaseRequirementSection(BaseSection baseSection) {
        this.baseSection = baseSection;
        for (BaseRequirement baseRequirement : BaseRequirement.values()) {
            if (baseSection == null) return;
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

    public BaseRequirementSection addRequirementType(BaseRequirement baseRequirement) {
        if (requirementTypes == null) requirementTypes = new ArrayList<>();
        requirementTypes.add(baseRequirement);
        return this;
    }
    public BaseRequirementSection addRequirementSectionOptions(BaseRequirement baseRequirement, RequirementSectionOptions requirementSectionOptions) {
        if (this.requirementSectionOptions == null) this.requirementSectionOptions = new HashMap<>();
        this.requirementSectionOptions.put(baseRequirement, requirementSectionOptions);
        return this;
    }
    public BaseRequirementSection addRequirementSection(BaseRequirement baseRequirement, RequirementSection requirementSection) {
        if (requirementSections == null) requirementSections = new HashMap<>();
        requirementSections.computeIfAbsent(baseRequirement, k -> new ArrayList<>());
        requirementSections.get(baseRequirement).add(requirementSection);
        return this;
    }
    public void save() {
        if (requirementTypes == null) return;
        for (BaseRequirement baseRequirement : requirementTypes) {
            requirementSectionOptions.get(baseRequirement).save();
            assert requirementSections != null;
            if (requirementSections.get(baseRequirement) == null) continue;
            for (RequirementSection requirementSection : requirementSections.get(baseRequirement)) {
                requirementSection.save();
            }
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
