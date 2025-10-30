package dev.akatriggered.g1axWorldGen;

import dev.akatriggered.g1axWorldGen.generator.BadlandsWorldGenerator;
import dev.akatriggered.g1axWorldGen.generator.DesertWorldGenerator;
import dev.akatriggered.g1axWorldGen.generator.MushroomWorldGenerator;
import dev.akatriggered.g1axWorldGen.generator.PlainsWorldGenerator;
import dev.akatriggered.g1axWorldGen.utils.TextStyle;
import org.bukkit.Bukkit;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public final class G1axWorldGenerator extends JavaPlugin {
    
    @Override
    public void onEnable() {
        sendConsoleMessage("<#0398fc>G1axWorldGenerator</#0398fc>", "<gray>Enabled</gray>");
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
        }
        return null;
    }
}
