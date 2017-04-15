package com.github.aistomin.musicist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by aistomin on 06/03/2017.
 * <p>
 * Demo Spring MVC controller.
 */
@Controller
public final class HelloController {

    /**
     * Print welcome message on the "Hello World" page.
     *
     * @param model The model.
     * @return The welcome message.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(final ModelMap model) {
        model.addAttribute("message", "MusicIST");
        return "index";
    }

    /**
     * Renders the "Hello World" page.
     *
     * @param name The name of the user.
     * @return The model and the view.
     */
    @RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") final String name) {
        final ModelAndView model = new ModelAndView();
        model.setViewName("index");
        model.addObject("msg", name);
        return model;
    }
}
