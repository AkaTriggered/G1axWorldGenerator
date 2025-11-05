package dev.akatriggered.g1axWorldGen.populator;

import java.util.Random;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class OceanPopulator extends BlockPopulator {
    public void populate(World world, Random random, Chunk chunk) {
        for (int i = 0; i < 5; i++) {
            int x = random.nextInt(16);
            int z = random.nextInt(16);
            int y = world.getHighestBlockYAt(chunk.getX() * 16 + x, chunk.getZ() * 16 + z);
            
            if (world.getBlockAt(chunk.getX() * 16 + x, y + 1, chunk.getZ() * 16 + z).getType() == Material.WATER) {
                if (random.nextInt(3) == 0) {
                    this.generateKelp(world, chunk.getX() * 16 + x, y + 1, chunk.getZ() * 16 + z, random);
                } else {
                    world.getBlockAt(chunk.getX() * 16 + x, y + 1, chunk.getZ() * 16 + z).setType(Material.BRAIN_CORAL);
                }
            }
        }
    }

    private void generateKelp(World world, int x, int y, int z, Random random) {
        int height = 2 + random.nextInt(4);
        for (int i = 0; i < height && world.getBlockAt(x, y + i, z).getType() == Material.WATER; i++) {
            world.getBlockAt(x, y + i, z).setType(Material.KELP_PLANT);
        }
    }
}
