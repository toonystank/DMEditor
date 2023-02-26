package com.toonystank.dmeditor.sections;


import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Getter
public class BaseCommandSection {
    public Map<ClickType,CommandSection> clickSection = new HashMap<>();
    public BaseSection baseSection;

    public BaseCommandSection(BaseSection baseSection) {
        this.baseSection = baseSection;
        Arrays.stream(ClickType.values()).forEach(click -> {
            if(baseSection.configManager.getConfig().contains("items." + baseSection.sectionName + "." + click.clickCommands)) {
                clickSection.put(click, new CommandSection(baseSection, this));
            }
        });
    }

    public BaseCommandSection addClickSection(ClickType clickType, CommandSection commandSection) {
        clickSection.put(clickType, commandSection);
        return this;
    }
    public void save() {
        clickSection.forEach((clickType, commandSection) -> commandSection.save());
    }


    public enum ClickType {
        CLICK("click_commands"),
        LEFT_CLICK("left_click_commands"),
        RIGHT_CLICK("right_click_commands"),
        SHIFT_LEFT_CLICK("shift_left_click_commands"),
        SHIFT_RIGHT_CLICK("shift_right_click_commands");


        public final String clickCommands;

        ClickType(String clickCommands) {
            this.clickCommands = clickCommands;
        }
    }
}
