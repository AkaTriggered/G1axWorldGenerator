package dev.akatriggered.g1axWorldGen.populator;

import java.util.Random;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class IcePopulator extends BlockPopulator {
    public void populate(World world, Random random, Chunk chunk) {
        if (random.nextInt(8) == 0) {
            int x = random.nextInt(16);
            int z = random.nextInt(16);
            int y = world.getHighestBlockYAt(chunk.getX() * 16 + x, chunk.getZ() * 16 + z) + 1;
            
            this.generateIceSpike(world, chunk.getX() * 16 + x, y, chunk.getZ() * 16 + z, random);
        }
        
        for (int i = 0; i < 4; i++) {
            int x = random.nextInt(16);
            int z = random.nextInt(16);
            int y = world.getHighestBlockYAt(chunk.getX() * 16 + x, chunk.getZ() * 16 + z) + 1;
            world.getBlockAt(chunk.getX() * 16 + x, y, chunk.getZ() * 16 + z).setType(Material.SNOW);
        }
    }

    private void generateIceSpike(World world, int x, int y, int z, Random random) {
        int height = 5 + random.nextInt(8);
        int width = 2;
        
        for (int i = 0; i < height; i++) {
            int currentWidth = Math.max(1, width - (i / 3));
            for (int dx = -currentWidth; dx <= currentWidth; dx++) {
                for (int dz = -currentWidth; dz <= currentWidth; dz++) {
                    if (Math.abs(dx) + Math.abs(dz) <= currentWidth) {
                        world.getBlockAt(x + dx, y + i, z + dz).setType(Material.BLUE_ICE);
                    }
                }
            }
        }
    }
}
