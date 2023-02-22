package com.toonystank.dmeditor.sections.requirement.types;


import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class JavaScript extends Requirements {

    public static RequirementTypes type = RequirementTypes.JAVA_SCRIPT;

    public String expression;

    public JavaScript() {
        super(type);
    }
}
