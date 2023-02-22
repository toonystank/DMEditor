package com.toonystank.dmeditor.sections.requirement.types;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@Setter
@Getter
public class HasItem extends Requirements {

    public static RequirementTypes type = RequirementTypes.HAS_ITEM;

    public HasItem() {
        super(type);
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
}
