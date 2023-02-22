package com.toonystank.dmeditor;

import com.toonystank.dmeditor.utils.DMConfig;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class DMEditor extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        if (getServer().getPluginManager().getPlugin("DeluxeMenus") == null) {
            getLogger().severe("DeluxeMenus not found! Disabling plugin.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        try {
            new DMConfig(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
