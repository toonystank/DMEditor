package com.toonystank.dmeditor.sections.requirement.types;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;

@Getter
public enum RequirementTypes {

    HAS_EXP("has exp", "!has exp"),
    HAS_MONEY("has money", "!has money"),
    HAS_ITEM("has item", "!has item"),
    HAS_META("has meta", "!has meta"),
    HAS_PERMISSION("has permission", "!has permission"),
    IS_NEAR("is near", "!is near"),
    JAVA_SCRIPT("javascript", null),
    STRING_CONTAINS("string contains", "!string contains"),
    STRING_EQUALS("string equals", "!string equals"),
    STRING_EQUALS_IGNORE_CASE("string equals ignore case", "!string equals ignore case");

    public final String yes;
    public final @Nullable String no;
    RequirementTypes(String yes, @Nullable String no) {
        this.yes = yes;
        this.no = no;
    }


}
