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
     * Check that we properly set fields on user during creation.
     *
     * @throws Exception If something goes wrong.
     */
    @Test
    public void testCreateUser() throws Exception {
        final FacebookUser user = new FacebookUser();
        final Long id = getRandom().nextLong();
        user.setId(id);
        final Set<Role> roles = new HashSet<>();
        roles.add(randomRole());
        user.setRoles(roles);
        final String fbid = UUID.randomUUID().toString();
        user.setFacebookId(fbid);
        final String email = fbid + "@test.de";
        user.setEmail(email);
        Assert.assertEquals(id, user.getId());
        Assert.assertEquals(1, user.getRoles().size());
        Assert.assertTrue(user.getRoles().containsAll(roles));
        Assert.assertEquals(fbid, user.getFacebookId());
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
}
