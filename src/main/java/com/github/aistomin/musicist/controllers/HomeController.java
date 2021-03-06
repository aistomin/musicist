package com.github.aistomin.musicist.controllers;

import com.github.aistomin.musicist.model.Fretboard;
import com.github.aistomin.musicist.model.Note;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by aistomin on 06/03/2017.
 * <p>
 * Home controller which processes the home page.
 */
@Controller
public final class HomeController {

    /**
     * Print welcome message on the "Hello World" page.
     *
     * @param model The model.
     * @return The welcome message.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(final ModelMap model) {
        model.addAttribute("message", "MusicIST");
        model.addAttribute("notes", Note.values());
        model.addAttribute("fretboard", new Fretboard());
        return "index";
    }
}
