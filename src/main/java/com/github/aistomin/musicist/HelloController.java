package com.github.aistomin.musicist;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
     * Log In.
     *
     * @param request  HTTP request.
     * @param response HTTP response.
     * @throws IOException If problem occurs.
     */
    @RequestMapping(value = "/facebook/login", method = RequestMethod.GET)
    public void loginWithFb(
        final HttpServletRequest request, final HttpServletResponse response
    ) throws IOException {
        final Facebook facebook = new FacebookFactory().getInstance();
        request.getSession().setAttribute("facebook", facebook);
        final StringBuffer callbackURL = request.getRequestURL();
        callbackURL.replace(
            callbackURL.lastIndexOf("/"), callbackURL.length(), ""
        ).append("/facebook/callback");
        response.sendRedirect(
            facebook.getOAuthAuthorizationURL(callbackURL.toString())
        );
    }

    /**
     * Facebook callback processor.
     *
     * @param request  HTTP request.
     * @param response HTTP response.
     * @throws IOException      If problem occurs.
     * @throws ServletException If problem occurs.
     */
    @RequestMapping(value = "/facebook/callback", method = RequestMethod.GET)
    public void fbCallback(
        final HttpServletRequest request, final HttpServletResponse response
    ) throws IOException, ServletException {
        final Facebook facebook = (Facebook) request.getSession()
            .getAttribute("facebook");
        final String oauthCode = request.getParameter("code");
        try {
            facebook.getOAuthAccessToken(oauthCode);
        } catch (FacebookException e) {
            throw new ServletException(e);
        }
        response.sendRedirect(request.getContextPath() + "/");
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
