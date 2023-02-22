package com.toonystank.dmeditor.sections.requirement.types;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
public class HasExp extends Requirements {

    public static RequirementTypes type = RequirementTypes.HAS_EXP;
    public HasExp() {
        super(type);
    }
    public Integer amount;
    public Boolean level;
}
