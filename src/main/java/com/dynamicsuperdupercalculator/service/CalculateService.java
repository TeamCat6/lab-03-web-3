package com.dynamicsuperdupercalculator.service;

import com.dynamicsuperdupercalculator.model.FunctionResult;

import java.util.List;

public class CalculateService {

    private final Result25Service result25Service = new Result25Service();
    private final Result26Service result26Service = new Result26Service();
    private final Result27Service result27Service = new Result27Service();

    public List<FunctionResult> getResults(double a, double b, double c, double d) {
        return List.of(
                result25Service.getResult(a, b, c, d),
                result26Service.getResult(a, b, c, d),
                result27Service.getResult(a, b, c, d)
        );
    }
}
