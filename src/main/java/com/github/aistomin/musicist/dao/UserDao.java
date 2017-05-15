package com.github.aistomin.musicist.dao;

import com.github.aistomin.musicist.model.entites.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * User data access object.
 */
@Component
@Transactional
public class UserDao {

    /**
     * Hibernate entity manager.
     */
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager manager;

    /**
     * Load all users.
     *
     * @return List of users.
     */
    public final List<User> list() {
        return manager.createQuery(
            "SELECT u FROM User u ORDER BY u.id", User.class
        ).getResultList();
    }

    /**
     * Delete user.
     *
     * @param id User's ID.
     */
    public final void delete(final int id) {
        manager.remove(manager.getReference(User.class, id));
    }

    /**
     * Save user.
     *
     * @param user User.
     */
    public final void save(final User user) {
        manager.persist(user);
    }
}
