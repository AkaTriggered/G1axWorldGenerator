package dev.akatriggered.g1axWorldGen.populator;

import java.util.Random;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class JunglePopulator extends BlockPopulator {
    public void populate(World world, Random random, Chunk chunk) {
        for (int i = 0; i < 8; i++) {
            int x = random.nextInt(16);
            int z = random.nextInt(16);
            int y = world.getHighestBlockYAt(chunk.getX() * 16 + x, chunk.getZ() * 16 + z) + 1;
            
            if (random.nextInt(3) == 0) {
                this.generateJungleTree(world, chunk.getX() * 16 + x, y, chunk.getZ() * 16 + z, random);
            } else {
                world.getBlockAt(chunk.getX() * 16 + x, y, chunk.getZ() * 16 + z).setType(Material.FERN);
            }
        }
    }

    private void generateJungleTree(World world, int x, int y, int z, Random random) {
        int height = 4 + random.nextInt(3);
        for (int i = 0; i < height; i++) {
            world.getBlockAt(x, y + i, z).setType(Material.JUNGLE_LOG);
        }
        
        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {
                world.getBlockAt(x + dx, y + height, z + dz).setType(Material.JUNGLE_LEAVES);
            }
        }
        
        if (random.nextInt(4) == 0) {
            world.getBlockAt(x, y + height - 1, z).setType(Material.VINE);
        }
    }
}
