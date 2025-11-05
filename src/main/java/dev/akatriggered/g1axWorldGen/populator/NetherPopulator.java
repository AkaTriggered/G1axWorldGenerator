package dev.akatriggered.g1axWorldGen.populator;

import java.util.Random;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class NetherPopulator extends BlockPopulator {
    public void populate(World world, Random random, Chunk chunk) {
        for (int i = 0; i < 6; i++) {
            int x = random.nextInt(16);
            int z = random.nextInt(16);
            int y = world.getHighestBlockYAt(chunk.getX() * 16 + x, chunk.getZ() * 16 + z) + 1;
            
            if (random.nextInt(3) == 0) {
                this.generateNetherTree(world, chunk.getX() * 16 + x, y, chunk.getZ() * 16 + z, random);
            } else if (random.nextInt(4) == 0) {
                world.getBlockAt(chunk.getX() * 16 + x, y, chunk.getZ() * 16 + z).setType(Material.NETHER_WART);
            }
        }
    }

    private void generateNetherTree(World world, int x, int y, int z, Random random) {
        int height = 4 + random.nextInt(3);
        
        for (int i = 0; i < height; i++) {
            world.getBlockAt(x, y + i, z).setType(Material.CRIMSON_STEM);
        }
        
        for (int dx = -2; dx <= 2; dx++) {
            for (int dz = -2; dz <= 2; dz++) {
                if (Math.abs(dx) + Math.abs(dz) <= 2) {
                    world.getBlockAt(x + dx, y + height, z + dz).setType(Material.NETHER_WART_BLOCK);
                }
            }
        }
        
        if (random.nextInt(3) == 0) {
            world.getBlockAt(x, y + height + 1, z).setType(Material.GLOWSTONE);
        }
    }
}
