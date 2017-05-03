package com.github.aistomin.musicist.model;

/**
 * Created by aistomin on 03.05.17.
 *
 * User that comes to musicist using Google account.
 */
public final class GoogleUser extends User {

    /**
     * Google user's ID.
     */
    private String googleId;

    /**
     * Get Google user's ID.
     * @return Google user's identifier.
     */
    public String getGoogleId() {
        return googleId;
    }

    /**
     * Set Google user's ID.
     * @param id Google user's identifier.
     */
    public void setGoogleId(final String id) {
        this.googleId = id;
    }
}
