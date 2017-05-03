package com.github.aistomin.musicist.model;

import com.github.aistomin.musicist.MusicistSuite;
import java.util.HashSet;
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
     * Check that we can create Facebook user.
     *
     * @throws Exception If something goes wrong.
     */
    @Test
    public void testCreateFbUser() throws Exception {
        final FacebookUser user = new FacebookUser();
        final Long id = getRandom().nextLong();
        user.setId(id);
        final Set<Role> roles = new HashSet<>();
        roles.add(randomRole());
        user.setRoles(roles);
        final String fbid = UUID.randomUUID().toString();
        user.setFacebookId(fbid);
        final String email = randomEmail();
        user.setEmail(email);
        Assert.assertEquals(id, user.getId());
        Assert.assertEquals(1, user.getRoles().size());
        Assert.assertTrue(user.getRoles().containsAll(roles));
        Assert.assertEquals(fbid, user.getFacebookId());
        Assert.assertEquals(email, user.getEmail());
    }

    /**
     * Check that we can create Facebook user.
     *
     * @throws Exception If something goes wrong.
     */
    @Test
    public void testCreateGoogleUser() throws Exception {
        final GoogleUser user = new GoogleUser();
        final Long id = getRandom().nextLong();
        user.setId(id);
        final Set<Role> roles = new HashSet<>();
        roles.add(randomRole());
        user.setRoles(roles);
        final String gid = UUID.randomUUID().toString();
        user.setGoogleId(gid);
        final String email = randomEmail();
        user.setEmail(email);
        Assert.assertEquals(id, user.getId());
        Assert.assertEquals(1, user.getRoles().size());
        Assert.assertTrue(user.getRoles().containsAll(roles));
        Assert.assertEquals(gid, user.getGoogleId());
        Assert.assertEquals(email, user.getEmail());
    }

    /**
     * Get random user's role.
     * @return Random role.
     */
    private Role randomRole() {
        final Role[] all = Role.values();
        return all[getRandom().nextInt(all.length)];
    }

    /**
     * Generate random email.
     * @return Random email.
     */
    private String randomEmail() {
        return UUID.randomUUID().toString() + "@test.de";
    }
}
