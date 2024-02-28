package com.dynamicsuperdupercalculator.servlet;

import com.dynamicsuperdupercalculator.model.Parameter;
import com.dynamicsuperdupercalculator.service.CalculateService;
import com.dynamicsuperdupercalculator.service.CookieService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DynamicSuperDuperCalculatorServlet", urlPatterns = {"/dynamicsuperdupercalculator"})
public class DynamicSuperDuperCalculatorServlet extends HttpServlet {

    private final CookieService cookieService = new CookieService();
    private final CalculateService calculateService = new CalculateService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        List<String> errors = new ArrayList<>();
        double a = getValue(request, Parameter.A, response, errors);
        double b = getValue(request, Parameter.B, response, errors);
        double c = getValue(request, Parameter.C, response, errors);
        double d = getValue(request, Parameter.D, response, errors);

        if (errors.isEmpty()) {
            request.setAttribute("functionResults", calculateService.getResults(a, b, c, d));
        } else {
            request.setAttribute("errors", errors);
        }

        request.getRequestDispatcher("/dynamicSuperDuperCalculator.jsp").forward(request, response);
    }

    private double getValue(
            HttpServletRequest request, Parameter parameter, HttpServletResponse response, List<String> errors) {
        String parameterValue = request.getParameter(parameter.name());

        try {
            if (parameterValue == null) {
                parameterValue = cookieService.getCookieValue(request, parameter);
            }

            return Double.parseDouble(parameterValue);
        } catch (Exception e) {
            errors.add("Parameter " + parameter + " is not valid");
        } finally {
            cookieService.setCookie(parameter, parameterValue, response);
            request.setAttribute(parameter.name(), parameterValue);
        }

        return 0;
    }
}