package com.toonystank.dmeditor.sections.requirement.types;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
public class HasMoney extends Requirements {


    public static RequirementTypes type = RequirementTypes.HAS_MONEY;
    public String money;

    public HasMoney() {
        super(type);
    }

    public HasMoney setMoney(String money) {
        this.money = money;
        return this;
    }
}
