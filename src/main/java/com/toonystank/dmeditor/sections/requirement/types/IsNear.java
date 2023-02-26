package com.toonystank.dmeditor.sections.requirement.types;

import com.toonystank.dmeditor.utils.ConfigManager;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;

@Setter
@Getter
public class IsNear extends Requirements {

    public static RequirementTypes type = RequirementTypes.IS_NEAR;

    public Location location;
    public Integer distance;

    public IsNear(String path, ConfigManager ConfigManager) {
        super(type,path,ConfigManager);
    }

    @Override
    public void save() {
        super.configManager.set(path + ".location", location.getWorld()+","+location.getX()+","+location.getY()+","+location.getZ());
        super.configManager.set(path + ".distance", distance);
        super.configManager.save();
    }
}
