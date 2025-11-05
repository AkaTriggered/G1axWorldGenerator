package dev.akatriggered.g1axWorldGen.generator;

import dev.akatriggered.g1axWorldGen.populator.PlainsPopulator;
import dev.akatriggered.g1axWorldGen.utils.NoiseUtil;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.ChunkGenerator.BiomeGrid;
import org.bukkit.generator.ChunkGenerator.ChunkData;

public class PlainsWorldGenerator extends ChunkGenerator {
   private final NoiseUtil noiseUtil = new NoiseUtil();

   public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome) {
      ChunkData chunk = this.createChunkData(world);
      int seaLevel = 63;
      int scale = 64;

      for(int x = 0; x < 16; ++x) {
         for(int z = 0; z < 16; ++z) {
            int worldX = chunkX * 16 + x;
            int worldZ = chunkZ * 16 + z;
            float mainNoise = this.noiseUtil.getMainNoise(worldX, worldZ);
            int height = seaLevel + (int)(0.125D * (double)scale + (double)mainNoise * 0.05D * (double)scale);
            this.setTerrainBlocks(chunk, x, z, height);
            biome.setBiome(x, z, Biome.PLAINS);
         }
      }

      return chunk;
   }

   private void setTerrainBlocks(ChunkData chunk, int x, int z, int height) {
      for(int y = -64; y <= height; ++y) {
         if (y <= -59) {
            chunk.setBlock(x, y, z, Material.BEDROCK);
         } else if (y <= 0) {
            chunk.setBlock(x, y, z, Material.DEEPSLATE);
         } else if (y <= height - 4) {
            chunk.setBlock(x, y, z, Material.STONE);
         } else if (y < height) {
            chunk.setBlock(x, y, z, Material.DIRT);
         } else {
            chunk.setBlock(x, y, z, Material.GRASS_BLOCK);
         }
      }

   }

   public List<BlockPopulator> getDefaultPopulators(World world) {
      return Arrays.asList(new PlainsPopulator());
   }
}
