package com.toonystank.dmeditor.sections.requirement.types;

import com.toonystank.dmeditor.utils.ConfigManager;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HasMeta extends Requirements {

    public static RequirementTypes type = RequirementTypes.HAS_META;
    public HasMeta(String path, ConfigManager configManager) {
        super(type, path, configManager);
    }
    public  String key;
    public MetaTypes metaType;
    public String value;

    @Override
    public void save() {
        super.configManager.set(path + ".key", key);
        super.configManager.set(path + ".metaType", metaType);
        super.configManager.set(path + ".value", value);
    }

    public enum MetaTypes {
        STRING,
        BOOLEAN,
        DOUBLE,
        LONG,
        INTEGER
    }


}
