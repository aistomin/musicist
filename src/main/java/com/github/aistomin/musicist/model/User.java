package com.github.aistomin.musicist.model;

/**
 * Created by aistomin on 01.05.17.
 * <p>
 * Application user.
 */
public final class User {

    /**
     * User's ID in musicist system.
     */
    private Long identifier;

    /**
     * Get User's ID in musicist system.
     * @return User's ID.
     */
    public Long getId() {
        return identifier;
    }

    /**
     * Set User's ID in musicist system.
     * @param id User's ID.
     */
    public void setId(final Long id) {
        this.identifier = id;
    }
}
