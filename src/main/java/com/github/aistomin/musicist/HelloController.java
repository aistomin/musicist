package com.github.aistomin.musicist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by aistomin on 06/03/2017.
 *
 * Demo Spring MVC controller.
 */
@Controller
public final class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(final ModelMap model) {
        model.addAttribute("message", "Spring 3 MVC Hello World");
        return "hello";
    }

    @RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") final String name) {
        final ModelAndView model = new ModelAndView();
        model.setViewName("hello");
        model.addObject("msg", name);
        return model;
    }
}
