package com.toonystank.dmeditor.sections.requirement.types;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StringEquals extends Requirements {

    public static RequirementTypes type = RequirementTypes.STRING_EQUALS;

    public String input;
    public String output;

    public StringEquals() {
        super(type);
    }
}
