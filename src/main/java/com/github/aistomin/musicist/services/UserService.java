package com.github.aistomin.musicist.services;

import com.github.aistomin.musicist.dao.UserDao;
import com.github.aistomin.musicist.model.entites.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User service.
 */
@Service
public class UserService {

    /**
     * User's DAO.
     */
    @Autowired
    private UserDao userDao;

    /**
     * List all the users.
     *
     * @return List of users.
     */
    public final List<User> list() {
        return userDao.list();
    }

    /**
     * Save user.
     *
     * @param user User.
     */
    public final void save(final User user) {
        userDao.save(user);
    }

    /**
     * Delete user.
     *
     * @param id User's ID.
     */
    public final void delete(final int id) {
        userDao.delete(id);
    }
}
