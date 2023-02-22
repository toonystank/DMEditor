package com.toonystank.dmeditor.sections;

import com.toonystank.dmeditor.utils.ConfigManager;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SectionItemOptions {

    public @Nullable Integer amount;
    public @Nullable Integer modelData;
    public @Nullable List<String> nbtTags;
    public @Nullable List<String> nbtInt;
    public @Nullable List<String> bannerMeta;
    public @Nullable List<String> itemFlags;
    public @Nullable String rgb;
    public @Nullable List<String> enchantments;
    public @Nullable Boolean hideEnchantments;
    public @Nullable Boolean hideAttributes;
    public @Nullable Boolean hideEffects;
    public @Nullable Boolean hideUnbreakable;
    public @Nullable Boolean unbreakable;
    public @Nullable String entityType;

    public SectionItemOptions(ConfigManager configManager, String sectionName) {
        this.amount = configManager.getInt("items." + sectionName + ".amount");
        this.modelData = configManager.getInt("items." + sectionName + ".model_data");
        this.nbtTags = configManager.getStringList("items." + sectionName + ".nbt_string");
        this.nbtInt = configManager.getStringList("items." + sectionName + ".nbt_int");
        this.bannerMeta = configManager.getStringList("items." + sectionName + ".banner_meta");
        this.itemFlags = configManager.getStringList("items." + sectionName + ".item_flags");
        this.rgb = configManager.getString("items." + sectionName + ".rgb");
        this.enchantments = configManager.getStringList("items." + sectionName + ".enchantments");
        this.hideEnchantments = configManager.getBoolean("items." + sectionName + ".hide_enchantments");
        this.hideAttributes = configManager.getBoolean("items." + sectionName + ".hide_attributes");
        this.hideEffects = configManager.getBoolean("items." + sectionName + ".hide_effects");
        this.hideUnbreakable = configManager.getBoolean("items." + sectionName + ".hide_unbreakable");
        this.unbreakable = configManager.getBoolean("items." + sectionName + ".unbreakable");
        this.entityType = configManager.getString("items." + sectionName + ".entity_type");
    }
}
