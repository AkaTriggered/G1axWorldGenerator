package dev.akatriggered.g1axWorldGen.populator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.BlockPopulator;

public class MushroomPopulator extends BlockPopulator {
   private final Random random = new Random();
   private final List<int[]> mushroomPositions = new ArrayList();

   public void populate(World world, Random random, Chunk chunk) {
      this.mushroomPositions.clear();
      int chunkX = chunk.getX();
      int chunkZ = chunk.getZ();

      for(int x = 0; x < 16; ++x) {
         for(int z = 0; z < 16; ++z) {
            if ((double)random.nextFloat() < 5.0E-4D && this.isFarEnough(x, z)) {
               this.mushroomPositions.add(new int[]{x, z});
               int worldX = chunkX * 16 + x;
               int worldZ = chunkZ * 16 + z;
               int height = world.getHighestBlockYAt(worldX, worldZ);
               Location location = new Location(world, (double)worldX, (double)(height + 1), (double)worldZ);
               Biome biome = world.getBiome(worldX, height, worldZ);
               if (biome == Biome.MUSHROOM_FIELDS) {
                  if (random.nextBoolean()) {
                     world.generateTree(location, TreeType.RED_MUSHROOM);
                  } else {
                     world.generateTree(location, TreeType.BROWN_MUSHROOM);
                  }
               }
            }
         }
      }

   }

   private boolean isFarEnough(int x, int z) {
      Iterator var3 = this.mushroomPositions.iterator();

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
