package com.github.aistomin.musicist.controllers;

import com.github.aistomin.musicist.model.entites.User;
import com.github.aistomin.musicist.services.UserService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by aistomin on 14/05/2017.
 * <p>
 * Test controller for testing database integration.
 */
@Controller
public final class UsersController {

    /**
     * All the paths realted to this controller will start with this prefix.
     */
    private static final String PREFIX = "/users";

    /**
     * User service.
     */
    @Autowired
    private UserService userService;

    /**
     * Renders users list.
     *
     * @param model Model.
     * @return User's view name.
     */
    @RequestMapping(value = PREFIX + "/", method = RequestMethod.GET)
    public String home(final Model model) {
        model.addAttribute("users", userService.list());
        return "users";
    }

    /**
     * Add new user.
     *
     * @return Redirect string.
     */
    @RequestMapping(value = PREFIX + "/add", method = RequestMethod.GET)
    public String addUser() {
        userService.save(new User("username_" + UUID.randomUUID().toString()));
        return "redirect:/users/";
    }

    /**
     * Delete user.
     *
     * @param id User's ID.
     * @return Redirect string.
     */
    @RequestMapping(
        value = PREFIX + "/delete/{id}", method = RequestMethod.GET
    )
    public String removeUser(@PathVariable("id") final int id) {
        userService.delete(id);
        return "redirect:/users/";
    }
}
