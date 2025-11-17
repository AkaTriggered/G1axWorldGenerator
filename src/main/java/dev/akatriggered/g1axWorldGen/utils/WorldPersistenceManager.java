package dev.akatriggered.g1axWorldGen.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class WorldPersistenceManager {
    private final JavaPlugin plugin;
    private final File configFile;
    private FileConfiguration config;
    private static final String CONFIG_VERSION = "1.1";

    public WorldPersistenceManager(JavaPlugin plugin) {
        this.plugin = plugin;
        this.configFile = new File(plugin.getDataFolder(), "g1ax_worlds.yml");
        loadConfig();
        migrateConfig();
    }

    private void loadConfig() {
        if (!configFile.exists()) {
            plugin.getDataFolder().mkdirs();
            try {
                configFile.createNewFile();
            } catch (IOException e) {
                plugin.getLogger().severe("Could not create g1ax_worlds.yml");
            }
        }
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    private void migrateConfig() {
        String currentVersion = config.getString("config-version", "1.0");
        
        if (!CONFIG_VERSION.equals(currentVersion)) {
            plugin.getLogger().info("Migrating g1ax_worlds.yml from version " + currentVersion + " to " + CONFIG_VERSION);
            
            if ("1.0".equals(currentVersion)) {
                migrateFromV1_0();
            }
            
            config.set("config-version", CONFIG_VERSION);
            config.set("last-updated", new Date().toString());
            saveConfig();
            
            plugin.getLogger().info("Configuration migration completed successfully");
        }
    }

    private void migrateFromV1_0() {
        if (config.contains("worlds")) {
            for (String worldName : config.getConfigurationSection("worlds").getKeys(false)) {
                if (!config.contains("worlds." + worldName + ".generated")) {
                    config.set("worlds." + worldName + ".generated", "Migrated from v1.0");
                    config.set("worlds." + worldName + ".version", "1.0");
                }
            }
        }
    }

    public boolean isWorldTracked(String worldName) {
        return config.contains("worlds." + worldName);
    }

    public void trackWorld(String worldName) {
        config.set("worlds." + worldName + ".generated", new Date().toString());
        config.set("worlds." + worldName + ".version", CONFIG_VERSION);
        saveConfig();
    }

    private void saveConfig() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            plugin.getLogger().severe("Could not save g1ax_worlds.yml: " + e.getMessage());
        }
    }
}
