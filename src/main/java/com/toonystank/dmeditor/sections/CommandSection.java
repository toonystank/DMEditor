package com.toonystank.dmeditor.sections;

import com.toonystank.dmeditor.sections.requirement.RequirementSection;

import java.util.List;

public class CommandSection extends RequirementSection {

    public List<String> commands;

    public CommandSection(BaseSection baseSection, BaseCommandSection baseCommandSection) {
        switch (baseCommandSection.getClickType()) {
            case CLICK:
                commands = baseSection.configManager.getStringList("items." + baseSection.sectionName + ".click_commands");
                break;
            case LEFT_CLICK:
                commands = baseSection.configManager.getStringList("items." + baseSection.sectionName + ".left_click_commands");
                break;
            case RIGHT_CLICK:
                commands = baseSection.configManager.getStringList("items." + baseSection.sectionName + ".right_click_commands");
                break;
            case SHIFT_LEFT_CLICK:
                commands = baseSection.configManager.getStringList("items." + baseSection.sectionName + ".shift_left_click_commands");
                break;
            case SHIFT_RIGHT_CLICK:
                commands = baseSection.configManager.getStringList("items." + baseSection.sectionName + ".shift_right_click_commands");
                break;
            default:
                throw new IllegalArgumentException("Unexpected value: " + baseCommandSection.getClickType());
        }
    }


}
