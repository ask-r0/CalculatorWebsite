package no.ntnu.dev.CalculatorAPI.controller;

import no.ntnu.dev.CalculatorAPI.model.Answer;
import no.ntnu.dev.CalculatorAPI.model.Expression;
import no.ntnu.dev.CalculatorAPI.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    Logger logger = LoggerFactory.getLogger(CalculatorController.class);
    @Autowired
    private CalculatorService service;

    @PostMapping("/api/calculate")
    @CrossOrigin
    public Answer getCalculation(@RequestBody Expression expression) {
        logger.info("New Request with expression: " + expression.getExpression());
        return this.service.calculate(expression.getExpression());
    }
}
