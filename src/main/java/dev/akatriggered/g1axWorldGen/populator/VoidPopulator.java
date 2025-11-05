package dev.akatriggered.g1axWorldGen.populator;

import java.util.Random;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class VoidPopulator extends BlockPopulator {
    public void populate(World world, Random random, Chunk chunk) {
        if (random.nextInt(50) == 0) {
            int x = random.nextInt(16);
            int z = random.nextInt(16);
            
            for (int y = 0; y < 256; y++) {
                if (world.getBlockAt(chunk.getX() * 16 + x, y, chunk.getZ() * 16 + z).getType() == Material.GRASS_BLOCK) {
                    if (random.nextInt(2) == 0) {
                        world.getBlockAt(chunk.getX() * 16 + x, y + 1, chunk.getZ() * 16 + z).setType(Material.DEAD_BUSH);
                    }
                    break;
                }
            }
        }
    }
}
