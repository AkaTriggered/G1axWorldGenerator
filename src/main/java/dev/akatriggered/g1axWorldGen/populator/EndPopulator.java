package dev.akatriggered.g1axWorldGen.populator;

import java.util.Random;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class EndPopulator extends BlockPopulator {
    public void populate(World world, Random random, Chunk chunk) {
        if (random.nextInt(10) == 0) {
            int x = random.nextInt(16);
            int z = random.nextInt(16);
            int y = world.getHighestBlockYAt(chunk.getX() * 16 + x, chunk.getZ() * 16 + z) + 1;
            
            if (random.nextInt(3) == 0) {
                this.generateChorusPlant(world, chunk.getX() * 16 + x, y, chunk.getZ() * 16 + z, random);
            }
        }
    }

    private void generateChorusPlant(World world, int x, int y, int z, Random random) {
        int height = 3 + random.nextInt(4);
        for (int i = 0; i < height; i++) {
            world.getBlockAt(x, y + i, z).setType(Material.CHORUS_PLANT);
        }
        world.getBlockAt(x, y + height, z).setType(Material.CHORUS_FLOWER);
    }
}
