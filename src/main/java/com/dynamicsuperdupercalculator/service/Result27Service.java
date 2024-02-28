package com.dynamicsuperdupercalculator.service;

import com.dynamicsuperdupercalculator.model.FunctionResult;

public class Result27Service {

    public FunctionResult getResult(double a, double b, double c, double d) {
        double result = getCalculate(a, b, c, d);
        return new FunctionResult(a, b, c, d, getCalculateView("a", "b", "c", "d"),
                getCalculateView(a, b, c, d), result);
    }

    private String getCalculateView(Object a, Object b, Object c, Object d) {
        return String.format("<math xmlns=\"http://www.w3.org/1998/Math/MathML\" display=\"block\">\n" +
                "  <mi>sin</mi>\n" +
                "  <mo data-mjx-texclass=\"NONE\">\u2061</mo>\n" +
                "  <mrow data-mjx-texclass=\"INNER\">\n" +
                "    <mo data-mjx-texclass=\"OPEN\">(</mo>\n" +
                "    <msup>\n" +
                "      <mi>%1$s</mi>\n" +
                "      <mrow>\n" +
                "        <mo>−</mo>\n" +
                "        <mi>%2$s</mi>\n" +
                "      </mrow>\n" +
                "    </msup>\n" +
                "    <mo data-mjx-texclass=\"CLOSE\">)</mo>\n" +
                "  </mrow>\n" +
                "  <mo>+</mo>\n" +
                "  <mn>3</mn>\n" +
                "  <mo>⋅</mo>\n" +
                "  <mrow data-mjx-texclass=\"INNER\">\n" +
                "    <mo data-mjx-texclass=\"OPEN\">|</mo>\n" +
                "    <mi>arccos</mi>\n" +
                "    <mo data-mjx-texclass=\"NONE\">\u2061</mo>\n" +
                "    <mrow data-mjx-texclass=\"INNER\">\n" +
                "      <mo data-mjx-texclass=\"OPEN\">(</mo>\n" +
                "      <mo>−</mo>\n" +
                "      <msqrt>\n" +
                "        <mfrac>\n" +
                "          <mi>%3$s</mi>\n" +
                "          <mi>%4$s</mi>\n" +
                "        </mfrac>\n" +
                "      </msqrt>\n" +
                "      <mo data-mjx-texclass=\"CLOSE\">)</mo>\n" +
                "    </mrow>\n" +
                "    <mo data-mjx-texclass=\"CLOSE\">|</mo>\n" +
                "  </mrow>\n" +
                "</math>", a, b, c, d);
    }

    private double getCalculate(double a, double b, double c, double d) {
        return Math.sin(Math.pow(a, -b)) + 3 * Math.abs(Math.acos(-Math.sqrt(c / d)));
    }
}
