package com.toonystank.dmeditor.sections.requirement.types;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StringEqualsIgnoreCase extends Requirements {

    public static RequirementTypes type = RequirementTypes.STRING_EQUALS_IGNORE_CASE;
    public String input;
    public String output;
    public StringEqualsIgnoreCase() {
        super(type);
    }
}
