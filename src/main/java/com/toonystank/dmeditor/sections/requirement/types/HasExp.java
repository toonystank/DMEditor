package com.toonystank.dmeditor.sections.requirement.types;

import com.toonystank.dmeditor.utils.ConfigManager;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class HasExp extends Requirements {

    public static RequirementTypes type = RequirementTypes.HAS_EXP;

    public HasExp(String path, ConfigManager ConfigManager) {
        super(type,path,ConfigManager);
    }
    public Integer amount;
    public Boolean level;

    @Override
    public void save() {
        super.configManager.set(path + ".amount", amount);
        super.configManager.set(path + ".level", level);
        super.configManager.save();
    }
}
