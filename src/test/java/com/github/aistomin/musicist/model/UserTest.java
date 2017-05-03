package com.github.aistomin.musicist.model;

import com.github.aistomin.musicist.MusicistSuite;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by aistomin on 01.05.17.
 * <p>
 * Test for {@link User}
 */
public final class UserTest extends MusicistSuite {

    /**
     * Check that we properly set fields on user during creation.
     *
     * @throws Exception If something goes wrong.
     */
    @Test
    public void testCreateUser() throws Exception {
        final Random random = getRandom();
        final FacebookUser user = new FacebookUser();
        final Long expectedId = random.nextLong();
        user.setId(expectedId);
        final Set<Role> expectedRoles = new HashSet<>();
        final Role[] roles = Role.values();
        expectedRoles.add(roles[random.nextInt(roles.length)]);
        user.setRoles(expectedRoles);
        final String expectedFbId = UUID.randomUUID().toString();
        user.setFacebookId(expectedFbId);
        final String expectedEmail = expectedFbId + "@test.de";
        user.setEmail(expectedEmail);
        Assert.assertEquals(expectedId, user.getId());
        Assert.assertEquals(1, user.getRoles().size());
        Assert.assertTrue(user.getRoles().containsAll(expectedRoles));
        Assert.assertEquals(expectedFbId, user.getFacebookId());
        Assert.assertEquals(expectedEmail, user.getEmail());
    }
}
