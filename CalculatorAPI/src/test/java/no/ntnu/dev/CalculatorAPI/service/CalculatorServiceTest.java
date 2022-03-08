package no.ntnu.dev.CalculatorAPI.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
Only example!!! (Instructive)
 */
@Nested
public class CalculatorServiceTest {

    @Test
    @DisplayName("isValidExpression test")
    public void isValidExpressionTest() {
        assertTrue(3 == 3);
    }
}
