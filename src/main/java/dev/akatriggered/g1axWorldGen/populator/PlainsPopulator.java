package dev.akatriggered.g1axWorldGen.populator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.BlockPopulator;

public class PlainsPopulator extends BlockPopulator {
   private final Random random = new Random();
   private final List<int[]> treePositions = new ArrayList();

   public void populate(World world, Random random, Chunk chunk) {
      this.treePositions.clear();
      int chunkX = chunk.getX();
      int chunkZ = chunk.getZ();

      for(int x = 0; x < 16; ++x) {
         for(int z = 0; z < 16; ++z) {
            int worldX = chunkX * 16 + x;
            int worldZ = chunkZ * 16 + z;
            int height = world.getHighestBlockYAt(worldX, worldZ);
            Location location = new Location(world, (double)worldX, (double)(height + 1), (double)worldZ);
            Biome biome = world.getBiome(worldX, height, worldZ);
            if (biome == Biome.PLAINS) {
               if ((double)random.nextFloat() < 3.0E-4D && this.isFarEnough(x, z)) {
                  this.treePositions.add(new int[]{x, z});
                  world.generateTree(location, TreeType.TREE);
               }

               if ((double)random.nextFloat() < 0.005D) {
                  world.getBlockAt(worldX, height + 1, worldZ).setType(Material.TALL_GRASS);
               }
            }
         }
      }

   }

   private boolean isFarEnough(int x, int z) {
      Iterator var3 = this.treePositions.iterator();

      int dx;
      int dz;
      do {
         if (!var3.hasNext()) {
            return true;
         }

         int[] pos = (int[])var3.next();
         dx = Math.abs(pos[0] - x);
         dz = Math.abs(pos[1] - z);
      } while(dx >= 8 || dz >= 8);

      return false;
   }
}
