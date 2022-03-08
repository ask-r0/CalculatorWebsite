package no.ntnu.dev.CalculatorAPI.service;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import no.ntnu.dev.CalculatorAPI.model.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    Logger logger = LoggerFactory.getLogger(CalculatorService.class);

    public Answer calculate(String expression) {
        if (isValidExpression(expression)) {
            DoubleEvaluator evaluator = new DoubleEvaluator();
            Double result = evaluator.evaluate(expression);

            logger.info("Expression: " + expression +" evaluated as valid with answer: " + result);

            return new Answer(result.toString());
        } else {
            logger.info("Expression: " + expression +" evaluated as invalid.");

            return new Answer("Invalid");
        }
    }

    private boolean isValidChar(char c) {
        char[] validChars = {'+', '-', '*', '/', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.'};

        for (char i : validChars) {
            if (c == i) return true;
        }
        return false;
    }

    private boolean isValidExpression(String expression) {
        boolean validExpression = true;
        for (int i = 0; i<expression.length(); i++) {
            if (!isValidChar(expression.charAt(i))) validExpression = false;
        }
        return validExpression;
    }
}
