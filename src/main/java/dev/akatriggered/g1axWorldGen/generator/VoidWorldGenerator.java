package dev.akatriggered.g1axWorldGen.generator;

import dev.akatriggered.g1axWorldGen.populator.VoidPopulator;
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

public class VoidWorldGenerator extends ChunkGenerator {
    private final NoiseUtil noiseUtil = new NoiseUtil();

    public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome) {
        ChunkData chunk = this.createChunkData(world);

        for(int x = 0; x < 16; ++x) {
            for(int z = 0; z < 16; ++z) {
                int worldX = chunkX * 16 + x;
                int worldZ = chunkZ * 16 + z;
                float mainNoise = this.noiseUtil.getMainNoise(worldX, worldZ);
                
                if (mainNoise > 0.3f && random.nextInt(20) == 0) {
                    int height = 60 + (int)(mainNoise * 40);
                    this.generateFloatingIsland(chunk, x, z, height, random);
                }
                biome.setBiome(x, z, Biome.THE_VOID);
            }
        }
        return chunk;
    }

    private void generateFloatingIsland(ChunkData chunk, int x, int z, int height, Random random) {
        int size = 2 + random.nextInt(3);
        for (int y = height; y < height + size; y++) {
            chunk.setBlock(x, y, z, Material.STONE);
        }
        chunk.setBlock(x, height + size, z, Material.GRASS_BLOCK);
    }

    public List<BlockPopulator> getDefaultPopulators(World world) {
        return Arrays.asList(new VoidPopulator());
    }
}
