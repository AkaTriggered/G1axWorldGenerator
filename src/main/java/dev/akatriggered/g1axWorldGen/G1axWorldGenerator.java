package dev.akatriggered.g1axWorldGen;

import dev.akatriggered.g1axWorldGen.generator.BadlandsWorldGenerator;
import dev.akatriggered.g1axWorldGen.generator.DesertWorldGenerator;
import dev.akatriggered.g1axWorldGen.generator.EndWorldGenerator;
import dev.akatriggered.g1axWorldGen.generator.IceWorldGenerator;
import dev.akatriggered.g1axWorldGen.generator.MushroomWorldGenerator;
import dev.akatriggered.g1axWorldGen.generator.NetherWorldGenerator;
import dev.akatriggered.g1axWorldGen.generator.PlainsWorldGenerator;
import dev.akatriggered.g1axWorldGen.generator.SnowWorldGenerator;
import dev.akatriggered.g1axWorldGen.generator.VoidWorldGenerator;
import dev.akatriggered.g1axWorldGen.utils.TextStyle;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public final class G1axWorldGenerator extends JavaPlugin implements Listener {
    
    @Override
    public void onEnable() {
        sendConsoleMessage("<#0398fc>G1axWorldGenerator</#0398fc>", "<gray>Enabled</gray>");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        sendConsoleMessage("<red>G1axWorldGenerator</red>", "<gray>Disabled</gray>");
    }

    private void sendConsoleMessage(String title, String status) {
        String[] lines = {
            "",
            "<#2b5dad>  ██████╗  ██╗ █████╗ ██╗  ██╗</#2b5dad>",
            "<#2b5dad> ██╔════╝ ███║██╔══██╗╚██╗██╔╝</#2b5dad>",
            "<#2b5dad> ██║  ███╗╚██║███████║ ╚███╔╝</#2b5dad>",
            "<#2b5dad> ██║   ██║ ██║██╔══██║ ██╔██╗</#2b5dad>",
            "<#2b5dad> ╚██████╔╝ ██║██║  ██║██╔╝ ██╗</#2b5dad>",
            "<#2b5dad>  ╚═════╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝</#2b5dad>",
            "  " + title + " v1.0.0 - " + status,
            "  <gray>Custom World Generator</gray>",
            ""
        };

        for (String line : lines) {
            Bukkit.getConsoleSender().sendMessage(TextStyle.parse(line));
        }
    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        if ("DESERT".equalsIgnoreCase(id)) {
            return new DesertWorldGenerator();
        } else if ("BADLANDS".equalsIgnoreCase(id)) {
            return new BadlandsWorldGenerator();
        } else if ("MUSHROOM".equalsIgnoreCase(id)) {
            return new MushroomWorldGenerator();
        } else if ("PLAINS".equalsIgnoreCase(id)) {
            return new PlainsWorldGenerator();
        } else if ("END".equalsIgnoreCase(id)) {
            return new EndWorldGenerator();
        } else if ("NETHER".equalsIgnoreCase(id)) {
            return new NetherWorldGenerator();
        } else if ("SNOW".equalsIgnoreCase(id)) {
            return new SnowWorldGenerator();
        } else if ("ICE".equalsIgnoreCase(id)) {
            return new IceWorldGenerator();
        } else if ("VOID".equalsIgnoreCase(id)) {
            return new VoidWorldGenerator();
        }
        return null;
    }

    @EventHandler
    public void onWorldLoad(WorldLoadEvent event) {
        World world = event.getWorld();
        if (world.getGenerator() instanceof BadlandsWorldGenerator || 
            world.getGenerator() instanceof DesertWorldGenerator ||
            world.getGenerator() instanceof EndWorldGenerator ||
            world.getGenerator() instanceof IceWorldGenerator ||
            world.getGenerator() instanceof MushroomWorldGenerator ||
            world.getGenerator() instanceof NetherWorldGenerator ||
            world.getGenerator() instanceof PlainsWorldGenerator ||
            world.getGenerator() instanceof SnowWorldGenerator ||
            world.getGenerator() instanceof VoidWorldGenerator) {
            
            // Basic settings
            world.setDifficulty(Difficulty.HARD);
            world.setSpawnFlags(false, false);
            world.setKeepSpawnInMemory(false);
            world.getWorldBorder().setSize(1000);
            
            // Performance optimizations
            world.setAutoSave(false);
            world.setTicksPerAnimalSpawns(0);
            world.setTicksPerMonsterSpawns(0);
            world.setTicksPerWaterSpawns(0);
            world.setTicksPerWaterAmbientSpawns(0);
            world.setTicksPerAmbientSpawns(0);
            world.setViewDistance(6);
            world.setSimulationDistance(4);
            
            // Game rules for optimization
            world.setGameRule(org.bukkit.GameRule.DO_DAYLIGHT_CYCLE, false);
            world.setGameRule(org.bukkit.GameRule.DO_WEATHER_CYCLE, false);
            world.setGameRule(org.bukkit.GameRule.DO_MOB_SPAWNING, false);
            world.setGameRule(org.bukkit.GameRule.DO_FIRE_TICK, false);
            world.setGameRule(org.bukkit.GameRule.MOB_GRIEFING, false);
            world.setGameRule(org.bukkit.GameRule.RANDOM_TICK_SPEED, 0);
            world.setGameRule(org.bukkit.GameRule.DO_TILE_DROPS, false);
            world.setGameRule(org.bukkit.GameRule.DO_ENTITY_DROPS, false);
            world.setGameRule(org.bukkit.GameRule.KEEP_INVENTORY, false);
            world.setGameRule(org.bukkit.GameRule.ANNOUNCE_ADVANCEMENTS, false);
            
            // Set time to day and clear weather
            world.setTime(6000);
            world.setStorm(false);
            world.setThundering(false);
        }
    }
}
