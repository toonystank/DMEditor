package com.toonystank.dmeditor.sections.requirement.types;

import com.toonystank.dmeditor.utils.ConfigManager;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StringEquals extends Requirements {

    public static RequirementTypes type = RequirementTypes.STRING_EQUALS;

    public String input;
    public String output;

    public StringEquals(String path, ConfigManager ConfigManager) {
        super(type,path,ConfigManager);
    }

    @Override
    public void save() {
        super.configManager.set(path + ".input", input);
        super.configManager.set(path + ".output", output);
        super.configManager.save();
    }
}
