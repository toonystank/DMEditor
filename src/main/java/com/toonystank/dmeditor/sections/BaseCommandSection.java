package com.toonystank.dmeditor.sections;


import lombok.Getter;

@Getter
public class BaseCommandSection{


    public CommandSection clickSection;
    public ClickType clickType;

    public BaseCommandSection(BaseSection baseSection, ClickType clickType) {
        this.clickType = clickType;
        clickSection = new CommandSection(baseSection, this);
    }

    public enum ClickType {
        CLICK,
        LEFT_CLICK,
        RIGHT_CLICK,
        SHIFT_LEFT_CLICK,
        SHIFT_RIGHT_CLICK
    }
}
