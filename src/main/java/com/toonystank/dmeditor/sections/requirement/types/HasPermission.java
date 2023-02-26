package com.toonystank.dmeditor.sections.requirement.types;

import com.toonystank.dmeditor.utils.ConfigManager;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HasPermission extends Requirements {

    public static RequirementTypes type = RequirementTypes.HAS_PERMISSION;
    public String permission;
    public HasPermission(String path, ConfigManager ConfigManager) {
        super(type,path,ConfigManager);
    }

    @Override
    public void save() {
        super.configManager.set(path + ".permission", permission);
        super.configManager.save();
    }
}
