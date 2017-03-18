package com.github.aistomin.musicist;

import facebook4j.FacebookFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by aistomin on 18/03/2017.
 *
 * The test checks that Facebook integration is working properly.
 */
public final class FacebookTest {

    /**
     * Can login to facebook.
     * @throws Exception If something goes wrong.
     * @todo Issue #10. Let's solve the problem with passing private Facebook
     * App data to Rultor and Travis and un-ignore the test.
     */
    @Ignore
    @Test
    public void testLogin() throws Exception {
        Assert.assertNotNull(
            new FacebookFactory().getInstance().getOAuthAccessTokenInfo()
                .getToken()
        );
    }
}
