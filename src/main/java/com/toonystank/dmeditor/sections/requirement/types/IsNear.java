package com.toonystank.dmeditor.sections.requirement.types;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IsNear extends Requirements {

    public static RequirementTypes type = RequirementTypes.IS_NEAR;

    public String location;
    public Integer distance;

    public IsNear() {
        super(type);
    }
}
