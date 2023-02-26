package com.toonystank.dmeditor.sections.requirement.types;

import com.toonystank.dmeditor.utils.ConfigManager;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@Setter
@Getter
public class HasItem extends Requirements {

    public static RequirementTypes type = RequirementTypes.HAS_ITEM;

    public HasItem(String path, ConfigManager configManager) {
        super(type, path, configManager);
    }

    public String material;
    public @Nullable String data;
    public @Nullable String modelData;
    public @Nullable Integer amount;
    public @Nullable String ItemName;
    public @Nullable List<String> lore;
    public @Nullable Boolean name_contains;
    public @Nullable Boolean name_ignoreCase;
    public @Nullable Boolean lore_contains;
    public @Nullable Boolean lore_ignoreCase;
    public @Nullable Boolean strict;
    public @Nullable Boolean armor;
    public @Nullable Boolean offhand;

    @Override
    public void save() {
        super.configManager.set(path + ".material", material);
        super.configManager.set(path + ".data", data);
        super.configManager.set(path + ".modelData", modelData);
        super.configManager.set(path + ".amount", amount);
        super.configManager.set(path + ".ItemName", ItemName);
        super.configManager.set(path + ".lore", lore);
        super.configManager.set(path + ".name_contains", name_contains);
        super.configManager.set(path + ".name_ignorecase", name_ignoreCase);
        super.configManager.set(path + ".lore_contains", lore_contains);
        super.configManager.set(path + ".lore_ignorecase", lore_ignoreCase);
        super.configManager.set(path + ".strict", strict);
        super.configManager.set(path + ".armor", armor);
        super.configManager.set(path + ".offhand", offhand);
        super.configManager.save();
    }
}
