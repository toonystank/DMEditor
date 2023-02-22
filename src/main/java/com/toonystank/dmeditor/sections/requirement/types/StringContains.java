package com.toonystank.dmeditor.sections.requirement.types;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StringContains extends Requirements {

    public static RequirementTypes type = RequirementTypes.STRING_CONTAINS;

    public String input;
    public String output;

    public StringContains() {
        super(type);
    }
}
