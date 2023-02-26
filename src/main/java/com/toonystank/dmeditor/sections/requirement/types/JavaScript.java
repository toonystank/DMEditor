package com.toonystank.dmeditor.sections.requirement.types;


import com.toonystank.dmeditor.utils.ConfigManager;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class JavaScript extends Requirements {

    public static RequirementTypes type = RequirementTypes.JAVA_SCRIPT;

    public String expression;

    public JavaScript(String path, ConfigManager ConfigManager) {
        super(type,path,ConfigManager);
    }

    @Override
    public void save() {
        super.configManager.set(path + ".expression", expression);
        super.configManager.save();
    }
}
