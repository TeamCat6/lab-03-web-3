package com.dynamicsuperdupercalculator.service;

import com.dynamicsuperdupercalculator.model.Parameter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieService {

    private static final String COOKIE_DEFAULT_VALUE = "1";

    public String getCookieValue(HttpServletRequest request, Parameter parameter) {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (parameter.name().equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return COOKIE_DEFAULT_VALUE;
    }

    public void setCookie(Parameter parameter, String value, HttpServletResponse response) {
        Cookie cookie = new Cookie(parameter.name(), value);
        cookie.setMaxAge(10 * 365 * 24 * 60 * 60); // ten years
        response.addCookie(cookie);
    }
}
