package com.github.aistomin.musicist;

import com.github.aistomin.musicist.model.Role;
import java.util.Random;
import java.util.UUID;

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

    /**
     * Get random user's role.
     * @return Random role.
     */
    public final Role randomRole() {
        final Role[] all = Role.values();
        return all[getRandom().nextInt(all.length)];
    }

    /**
     * Generate random email.
     * @return Random email.
     */
    public final String randomEmail() {
        return UUID.randomUUID().toString() + "@test.de";
    }
}
