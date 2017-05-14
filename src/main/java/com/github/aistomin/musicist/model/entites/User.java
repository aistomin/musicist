package com.github.aistomin.musicist.model.entites;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * User entity.
 */
@Entity
@Table
public final class User implements Serializable {

    /**
     * Serialisation UID.
     */
    private static final long serialVersionUID = 6541162783907686900L;

    /**
     * Identifier.
     */
    @Id
    @GeneratedValue
    private int id;

    /**
     * Username.
     */
    @Column
    private String username;

    /**
     * Record's version.
     */
    @Version
    private long version;

    /**
     * Ctor.
     */
    public User() {
        super();
    }

    /**
     * Ctor.
     * @param name Username.
     */
    public User(final String name) {
        super();
        this.username = name;
    }

    /**
     * Get user's ID.
     * @return User's ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Set user's ID.
     * @param identifier User's ID.
     */
    public void setId(final int identifier) {
        this.id = identifier;
    }

    /**
     * Get username.
     * @return Username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set username.
     * @param name Username.
     */
    public void setUsername(final String name) {
        this.username = name;
    }

    /**
     * Get record's version.
     * @return Version.
     */
    public long getVersion() {
        return version;
    }

    /**
     * Set record's version.
     * @param ver Record's version.
     */
    public void setVersion(final long ver) {
        this.version = ver;
    }
}
