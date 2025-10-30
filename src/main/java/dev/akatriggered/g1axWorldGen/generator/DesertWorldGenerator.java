package dev.akatriggered.g1axWorldGen.generator;

import dev.akatriggered.g1axWorldGen.utils.NoiseUtil;
import java.util.Random;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.ChunkGenerator.BiomeGrid;
import org.bukkit.generator.ChunkGenerator.ChunkData;

public class DesertWorldGenerator extends ChunkGenerator {
   private final NoiseUtil noiseUtil = new NoiseUtil();
   private final Random random = new Random();

   public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome) {
      ChunkData chunk = this.createChunkData(world);
      int seaLevel = 63;
      int scale = 64;
      int duneAmplitude = 5;

      for(int x = 0; x < 16; ++x) {
         for(int z = 0; z < 16; ++z) {
            int worldX = chunkX * 16 + x;
            int worldZ = chunkZ * 16 + z;
            float mainNoise = this.noiseUtil.getMainNoise(worldX, worldZ);
            float duneNoise = this.noiseUtil.getDuneNoise(worldX, worldZ);
            int height = seaLevel + (int)(0.125D * (double)scale + (double)mainNoise * 0.05D * (double)scale);
            height += (int)(Math.max(0.0F, duneNoise) * (float)duneAmplitude);
            this.setTerrainBlocks(chunk, x, z, height);
            this.decorateSurface(chunk, x, z, height);
            biome.setBiome(x, z, Biome.DESERT);
         }
      }

      return chunk;
   }

   private void setTerrainBlocks(ChunkData chunk, int x, int z, int height) {
      for(int y = -64; y <= height; ++y) {
         if (y <= -59) {
            chunk.setBlock(x, y, z, Material.BEDROCK);
         } else if (y <= -1) {
            chunk.setBlock(x, y, z, Material.DEEPSLATE);
         } else if (y == 0) {
            chunk.setBlock(x, y, z, Material.DEEPSLATE);
         } else if (y >= height - 3) {
            chunk.setBlock(x, y, z, Material.SAND);
         } else if (y >= height - 7) {
            chunk.setBlock(x, y, z, Material.SANDSTONE);
         } else {
            chunk.setBlock(x, y, z, Material.STONE);
         }
      }

   }

   private void decorateSurface(ChunkData chunk, int x, int z, int height) {
      if ((double)this.random.nextFloat() < 0.002D) {
         int cactusHeight = this.random.nextInt(3) + 1;

         for(int y = 0; y < cactusHeight; ++y) {
            chunk.setBlock(x, height + 1 + y, z, Material.CACTUS);
         }
      } else if ((double)this.random.nextFloat() < 0.004D) {
         chunk.setBlock(x, height + 1, z, Material.DEAD_BUSH);
      }

   }
}
