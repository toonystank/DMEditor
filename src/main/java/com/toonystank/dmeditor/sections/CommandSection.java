package com.toonystank.dmeditor.sections;

import com.toonystank.dmeditor.sections.requirement.BaseRequirementSection;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandSection {

    public BaseSection baseSection;
    public Map<BaseCommandSection.ClickType, List<String>> commands = new HashMap<>();
    public BaseRequirementSection requirementSection;


    public CommandSection(BaseSection baseSection, @Nullable BaseCommandSection baseCommandSection) {
        this.baseSection = baseSection;
        if (baseCommandSection != null) {
            baseCommandSection.getClickSection().forEach((clickType, commandSection) -> commands.put(clickType, baseSection.configManager.getStringList("items." + baseSection.sectionName + "." + clickType.clickCommands)));
        }
        requirementSection = new BaseRequirementSection(baseSection);
    }
    public CommandSection addCommand(BaseCommandSection.ClickType clickType, List<String> commands) {
        this.commands.put(clickType, commands);
        return this;
    }
    public CommandSection addRequirementSection(BaseRequirementSection requirementSection) {
        this.requirementSection = requirementSection;
        return this;
    }
    public void save() {
        commands.forEach((clickType, commandList) -> baseSection.configManager.set("items." + baseSection.sectionName + "." + clickType.clickCommands, commandList));
        requirementSection.save();
    }



}
