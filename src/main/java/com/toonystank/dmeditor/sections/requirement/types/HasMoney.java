package com.toonystank.dmeditor.sections.requirement.types;

import com.toonystank.dmeditor.utils.ConfigManager;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
public class HasMoney extends Requirements {


    public static RequirementTypes type = RequirementTypes.HAS_MONEY;
    public String money;

    public HasMoney(String path, @NotNull ConfigManager configManager) {
        super(type, path, configManager);
    }

    public HasMoney setMoney(String money) {
        this.money = money;
        return this;
    }

    @Override
    public void save() {
        super.configManager.set(path + ".amount", money);
        super.configManager.save();
    }
}
