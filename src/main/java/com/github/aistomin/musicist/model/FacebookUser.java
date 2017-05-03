package com.github.aistomin.musicist.model;

/**
 * Created by aistomin on 03.05.17.
 *
 * User that comes to musicist using Facebook account.
 */
public final class FacebookUser extends User {

    /**
     * Facebook user's ID.
     */
    private String facebookId;

    /**
     * Get Facebook user's ID.
     * @return Facebook user's identifier.
     */
    public String getFacebookId() {
        return facebookId;
    }

    /**
     * Set Facebook user's ID.
     * @param id Facebook user's identifier.
     */
    public void setFacebookId(final String id) {
        this.facebookId = id;
    }
}
