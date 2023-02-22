package com.toonystank.dmeditor.sections.requirement.types;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HasPermission extends Requirements {

    public static RequirementTypes type = RequirementTypes.HAS_PERMISSION;
    public String permission;
    public HasPermission() {
        super(type);
    }
}
