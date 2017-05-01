package com.github.aistomin.musicist;

import java.util.Random;

/**
 * Created by aistomin on 01.05.17.
 * <p>
 * Base class for tests suites.
 */
@SuppressWarnings("WeakerAccess")
public abstract class MusicistSuite {

    /**
     * Randomiser for tests.
     */
    private final Random random = new Random();

    /**
     * Get test randomiser.
     * @return Test randomiser.
     */
    public final Random getRandom() {
        return random;
    }
}
