package com.github.aistomin.musicist.model;

import java.util.Set;

/**
 * Created by aistomin on 01.05.17.
 * <p>
 * Application user.
 */
public final class User {

    /**
     * User's ID in musicist system.
     */
    private Long id;

    /**
     * User's roles in musicist system.
     */
    private Set<Role> roles;

    /**
     * Get User's ID in musicist system.
     * @return User's ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set User's ID in musicist system.
     * @param identifier User's ID.
     */
    public void setId(final Long identifier) {
        this.id = identifier;
    }

    /**
     * Get user's roles in musicist system.
     * @return List of user's roles.
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Set user's roles in musicist system.
     * @param set List of user's roles.
     */
    public void setRoles(final Set<Role> set) {
        this.roles = set;
    }
}
