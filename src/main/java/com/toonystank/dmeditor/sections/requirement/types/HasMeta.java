package com.toonystank.dmeditor.sections.requirement.types;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Setter
@Getter
public class HasMeta extends Requirements {

    public static RequirementTypes type = RequirementTypes.HAS_META;
    public HasMeta() {
        super(type);
    }
    public  String key;
    public MetaTypes metaType;
    public enum MetaTypes {
        STRING,
        BOOLEAN,
        DOUBLE,
        LONG,
        INTEGER;
    }

    public String value;

}
