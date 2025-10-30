package dev.akatriggered.g1axWorldGen.utils;

public class NoiseUtil {
    private final FastNoiseLite mainNoise = new FastNoiseLite();
    private final FastNoiseLite duneNoise;

    public NoiseUtil() {
        mainNoise.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        mainNoise.SetFractalType(FastNoiseLite.FractalType.FBm);
        mainNoise.SetFractalOctaves(8);
        mainNoise.SetFrequency(0.005f);
        
        duneNoise = new FastNoiseLite();
        duneNoise.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        duneNoise.SetFrequency(0.05f);
    }

    public float getMainNoise(int x, int z) {
        return mainNoise.GetNoise((float) x, (float) z);
    }

    public float getDuneNoise(int x, int z) {
        return duneNoise.GetNoise((float) x, (float) z);
    }
}
