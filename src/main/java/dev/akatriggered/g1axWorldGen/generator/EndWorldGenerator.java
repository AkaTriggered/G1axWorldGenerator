package dev.akatriggered.g1axWorldGen.generator;

import dev.akatriggered.g1axWorldGen.populator.EndPopulator;
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

public class EndWorldGenerator extends ChunkGenerator {
    private final NoiseUtil noiseUtil = new NoiseUtil();

    public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome) {
        ChunkData chunk = this.createChunkData(world);
        int baseLevel = 64;

        for(int x = 0; x < 16; ++x) {
            for(int z = 0; z < 16; ++z) {
                int worldX = chunkX * 16 + x;
                int worldZ = chunkZ * 16 + z;
                float mainNoise = this.noiseUtil.getMainNoise(worldX, worldZ);
                int height = baseLevel + (int)(mainNoise * 20);
                this.setTerrainBlocks(chunk, x, z, height);
                biome.setBiome(x, z, Biome.THE_END);
            }
        }
        return chunk;
    }

    private void setTerrainBlocks(ChunkData chunk, int x, int z, int height) {
        for(int y = 0; y <= height; ++y) {
            chunk.setBlock(x, y, z, Material.END_STONE);
        }
    }

    public List<BlockPopulator> getDefaultPopulators(World world) {
        return Arrays.asList(new EndPopulator());
    }
}
