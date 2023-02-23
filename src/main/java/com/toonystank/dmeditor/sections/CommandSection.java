package com.toonystank.dmeditor.sections;

import com.toonystank.dmeditor.sections.requirement.BaseRequirementSection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandSection {

    public Map<BaseCommandSection.ClickType, List<String>> commands = new HashMap<>();
    public BaseRequirementSection requirementSection;

    public CommandSection(BaseSection baseSection, BaseCommandSection baseCommandSection) {
        switch (baseCommandSection.getClickType()) {
            case CLICK:
                commands.put(BaseCommandSection.ClickType.CLICK, baseSection.configManager.getStringList("items." + baseSection.sectionName + ".click_commands"));
                break;
            case LEFT_CLICK:
                commands.put(BaseCommandSection.ClickType.LEFT_CLICK,baseSection.configManager.getStringList("items." + baseSection.sectionName + ".left_click_commands"));
                break;
            case RIGHT_CLICK:
                commands.put(BaseCommandSection.ClickType.RIGHT_CLICK,baseSection.configManager.getStringList("items." + baseSection.sectionName + ".right_click_commands"));
                break;
            case SHIFT_LEFT_CLICK:
                commands.put(BaseCommandSection.ClickType.SHIFT_LEFT_CLICK,baseSection.configManager.getStringList("items." + baseSection.sectionName + ".shift_left_click_commands"));
                break;
            case SHIFT_RIGHT_CLICK:
                commands.put(BaseCommandSection.ClickType.SHIFT_RIGHT_CLICK,baseSection.configManager.getStringList("items." + baseSection.sectionName + ".shift_right_click_commands"));
                break;
            default:
                throw new IllegalArgumentException("Unexpected value: " + baseCommandSection.getClickType());
        }
        requirementSection = new BaseRequirementSection(baseSection);
    }



}
