package dev.akatriggered.g1axWorldGen.generator;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;
import org.bukkit.util.noise.SimplexOctaveGenerator;

import java.util.Random;

public class SpleefWorldGenerator extends ChunkGenerator {
    private final SpleefType type;
    private final int layers;

    public enum SpleefType {
        SNOW(Material.SNOW_BLOCK),
        DIRT(Material.DIRT),
        MULTI(Material.DIRT);

        private final Material material;

        SpleefType(Material material) {
            this.material = material;
        }

        public Material getMaterial() {
            return material;
        }
    }

    public SpleefWorldGenerator(SpleefType type, int layers) {
        this.type = type;
        this.layers = Math.max(2, Math.min(5, layers));
    }

    @Override
    public void generateNoise(WorldInfo worldInfo, Random random, int chunkX, int chunkZ, ChunkData chunkData) {
        SimplexOctaveGenerator generator = new SimplexOctaveGenerator(new Random(worldInfo.getSeed()), 8);
        generator.setScale(0.005D);

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                int worldX = chunkX * 16 + x;
                int worldZ = chunkZ * 16 + z;

                for (int layer = 0; layer < layers; layer++) {
                    int y = 64 + (layer * 5);
                    Material blockType = getBlockForLayer(layer, worldX, worldZ, random);
                    chunkData.setBlock(x, y, z, blockType);
                }
            }
        }
    }

    private Material getBlockForLayer(int layer, int x, int z, Random random) {
        switch (type) {
            case SNOW:
                return Material.SNOW_BLOCK;
            case DIRT:
                return Material.DIRT;
            case MULTI:
                return (layer % 2 == 0) ? Material.DIRT : Material.SNOW_BLOCK;
            default:
                return Material.SNOW_BLOCK;
        }
    }
}
