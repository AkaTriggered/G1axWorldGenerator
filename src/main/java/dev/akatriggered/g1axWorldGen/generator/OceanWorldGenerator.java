package dev.akatriggered.g1axWorldGen.generator;

import dev.akatriggered.g1axWorldGen.populator.OceanPopulator;
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

public class OceanWorldGenerator extends ChunkGenerator {
    private final NoiseUtil noiseUtil = new NoiseUtil();

    public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome) {
        ChunkData chunk = this.createChunkData(world);
        int seaLevel = 63;
        int oceanFloor = 30;

        for(int x = 0; x < 16; ++x) {
            for(int z = 0; z < 16; ++z) {
                int worldX = chunkX * 16 + x;
                int worldZ = chunkZ * 16 + z;
                float mainNoise = this.noiseUtil.getMainNoise(worldX, worldZ);
                int height = oceanFloor + (int)(mainNoise * 15);
                this.setTerrainBlocks(chunk, x, z, height, seaLevel);
                biome.setBiome(x, z, Biome.DEEP_OCEAN);
            }
        }
        return chunk;
    }

    private void setTerrainBlocks(ChunkData chunk, int x, int z, int height, int seaLevel) {
        for(int y = -64; y <= seaLevel; ++y) {
            if (y <= -59) {
                chunk.setBlock(x, y, z, Material.BEDROCK);
            } else if (y <= height - 3) {
                chunk.setBlock(x, y, z, Material.STONE);
            } else if (y <= height) {
                chunk.setBlock(x, y, z, Material.SAND);
            } else if (y <= seaLevel) {
                chunk.setBlock(x, y, z, Material.WATER);
            }
        }
    }

    public List<BlockPopulator> getDefaultPopulators(World world) {
        return Arrays.asList(new OceanPopulator());
    }
}
