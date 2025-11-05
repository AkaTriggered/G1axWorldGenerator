package dev.akatriggered.g1axWorldGen.generator;

import dev.akatriggered.g1axWorldGen.populator.JunglePopulator;
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

public class JungleWorldGenerator extends ChunkGenerator {
    private final NoiseUtil noiseUtil = new NoiseUtil();

    public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome) {
        ChunkData chunk = this.createChunkData(world);
        int seaLevel = 63;

        for(int x = 0; x < 16; ++x) {
            for(int z = 0; z < 16; ++z) {
                int worldX = chunkX * 16 + x;
                int worldZ = chunkZ * 16 + z;
                float mainNoise = this.noiseUtil.getMainNoise(worldX, worldZ);
                int height = seaLevel + (int)(mainNoise * 35);
                this.setTerrainBlocks(chunk, x, z, height);
                biome.setBiome(x, z, Biome.JUNGLE);
            }
        }
        return chunk;
    }

    private void setTerrainBlocks(ChunkData chunk, int x, int z, int height) {
        for(int y = -64; y <= height; ++y) {
            if (y <= -59) {
                chunk.setBlock(x, y, z, Material.BEDROCK);
            } else if (y <= height - 5) {
                chunk.setBlock(x, y, z, Material.STONE);
            } else if (y < height) {
                chunk.setBlock(x, y, z, Material.DIRT);
            } else {
                chunk.setBlock(x, y, z, Material.GRASS_BLOCK);
            }
        }
    }

    public List<BlockPopulator> getDefaultPopulators(World world) {
        return Arrays.asList(new JunglePopulator());
    }
}
