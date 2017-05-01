package com.github.aistomin.musicist.controllers;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by aistomin on 15/04/2017.
 * <p>
 * Controller which is responsible for interaction with Facebook.
 * Initially the code was stolen from
 * https://github.com/roundrop/facebook4j-oauth-example
 */
@Controller
public final class FbController {

    /**
     * All the paths realted to this controller will start with this prefix.
     */
    private static final String PREFIX = "/facebook";

    /**
     * SLF4J Logger.
     */
    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * Log In.
     *
     * @param request  HTTP request.
     * @param response HTTP response.
     * @throws IOException If problem occurs.
     */
    @RequestMapping(value = PREFIX + "/login", method = RequestMethod.GET)
    public void login(
        final HttpServletRequest request, final HttpServletResponse response
    ) throws IOException {
        log.debug("FbController.login() was called.");
        final Facebook facebook = new FacebookFactory().getInstance();
        request.getSession().setAttribute("facebook", facebook);
        final StringBuffer callbackURL = request.getRequestURL();
        callbackURL.replace(
            callbackURL.lastIndexOf("/"), callbackURL.length(), ""
        ).append("/callback");
        response.sendRedirect(
            facebook.getOAuthAuthorizationURL(callbackURL.toString())
        );
    }

    /**
     * Log Out.
     *
     * @param request  HTTP request.
     * @param response HTTP response.
     * @throws IOException      If problem occurs.
     * @throws ServletException If problem occurs.
     */
    @RequestMapping(value = PREFIX + "/logout", method = RequestMethod.GET)
    public void logout(
        final HttpServletRequest request, final HttpServletResponse response
    ) throws IOException, ServletException {
        log.debug("FbController.logout() was called.");
        final Facebook facebook = (Facebook) request.getSession()
            .getAttribute("facebook");
        final String accessToken;
        try {
            accessToken = facebook.getOAuthAccessToken().getToken();
            facebook.deleteAllPermissions();
        } catch (final Exception e) {
            throw new ServletException(e);
        }
        request.getSession().invalidate();
        final StringBuffer next = request.getRequestURL();
        next.replace(next.lastIndexOf("/") + 1, next.length(), "");
        final String redirect = "http://www.facebook.com/logout.php?next="
            + next.toString() + "&access_token=" + accessToken;
        log.debug(
            "FbController.logout: User will be redirected to: " + redirect
        );
        response.sendRedirect(redirect);
    }

    /**
     * Facebook callback processor.
     *
     * @param request  HTTP request.
     * @param response HTTP response.
     * @throws IOException      If problem occurs.
     * @throws ServletException If problem occurs.
     */
    @RequestMapping(value = PREFIX + "/callback", method = RequestMethod.GET)
    public void callback(
        final HttpServletRequest request, final HttpServletResponse response
    ) throws IOException, ServletException {
        log.debug("FbController.callback() was called.");
        final Facebook facebook = (Facebook) request.getSession()
            .getAttribute("facebook");
        final String oauthCode = request.getParameter("code");
        try {
            facebook.getOAuthAccessToken(oauthCode);
        } catch (final FacebookException e) {
            throw new ServletException(e);
        }
        response.sendRedirect(request.getContextPath() + "/");
    }
}
