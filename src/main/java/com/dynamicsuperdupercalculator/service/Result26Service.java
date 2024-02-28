package com.dynamicsuperdupercalculator.service;

import com.dynamicsuperdupercalculator.model.FunctionResult;

public class Result26Service {

    public FunctionResult getResult(double a, double b, double c, double d) {
        double result = getCalculate(a, b, c, d);
        return new FunctionResult(a, b, c, d, getCalculateView("a", "b", "c", "d"),
                getCalculateView(a, b, c, d), result);
    }

    private String getCalculateView(Object a, Object b, Object c, Object d) {
        return String.format("<math xmlns=\"http://www.w3.org/1998/Math/MathML\" display=\"block\">\n" +
                "  <mfrac>\n" +
                "    <mroot>\n" +
                "      <mrow>\n" +
                "        <mi>tg</mi>\n" +
                "        <mo data-mjx-texclass=\"NONE\">\u2061</mo>\n" +
                "        <mo stretchy=\"false\">(</mo>\n" +
                "        <mi>%1$s</mi>\n" +
                "        <mo stretchy=\"false\">)</mo>\n" +
                "      </mrow>\n" +
                "      <mi>%3$s</mi>\n" +
                "    </mroot>\n" +
                "    <mrow>\n" +
                "      <mn>2</mn>\n" +
                "      <mo>−</mo>\n" +
                "      <mfrac>\n" +
                "        <mrow>\n" +
                "          <mi>sh</mi>\n" +
                "          <mo data-mjx-texclass=\"NONE\">\u2061</mo>\n" +
                "          <mo stretchy=\"false\">(</mo>\n" +
                "          <mi>%2$s</mi>\n" +
                "          <mo stretchy=\"false\">)</mo>\n" +
                "        </mrow>\n" +
                "        <mrow>\n" +
                "          <mi>ln</mi>\n" +
                "          <mo data-mjx-texclass=\"NONE\">\u2061</mo>\n" +
                "          <mrow>\n" +
                "            <mo stretchy=\"false\">|</mo>\n" +
                "          </mrow>\n" +
                "          <mi>%4$s</mi>\n" +
                "          <mo>+</mo>\n" +
                "          <mi>%3$s</mi>\n" +
                "          <mo stretchy=\"false\">|</mo>\n" +
                "        </mrow>\n" +
                "      </mfrac>\n" +
                "    </mrow>\n" +
                "  </mfrac>\n" +
                "</math>", a, b, c, d);
    }

    private double getCalculate(double a, double b, double c, double d) {
        return Math.pow(Math.sqrt(Math.tan(a)), c) / 2 - (Math.sinh(b) / Math.log(Math.abs(d + c)));
    }
}
