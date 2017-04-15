package com.github.aistomin.musicist;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by aistomin on 15/04/2017.
 * <p>
 * Controller which is responsible for interaction with Facebook.
 */
@Controller
public final class FbController {

    /**
     * Log In.
     *
     * @param request  HTTP request.
     * @param response HTTP response.
     * @throws IOException If problem occurs.
     */
    @RequestMapping(value = "/facebook/login", method = RequestMethod.GET)
    public void login(
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
    public void callback(
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
}
