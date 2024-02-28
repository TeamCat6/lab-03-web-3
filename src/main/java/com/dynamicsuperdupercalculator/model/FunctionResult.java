package com.dynamicsuperdupercalculator.model;

public class FunctionResult {

    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private final String functionView;
    private final String functionWithValuesView;
    private final String result;

    public FunctionResult(double a, double b, double c, double d, String functionView, String functionWithValuesView, Double result) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.functionView = functionView;
        this.functionWithValuesView = functionWithValuesView;
        this.result = result.isNaN() ? "Not defined" : result.toString();
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public String getFunctionView() {
        return functionView;
    }

    public String getFunctionWithValuesView() {
        return functionWithValuesView;
    }

    public String getResult() {
        return result;
    }
}
