package by.gstu.project.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testArithmeticOperations() {
        Calculator calc = new Calculator();
        assertEquals(20.0, calc.add(12, 8), 1e-9);
        assertEquals(11.0, calc.subtract(15, 4), 1e-9);
        assertEquals(42.0, calc.multiply(6, 7), 1e-9);
        assertEquals(5.0, calc.divide(20, 4), 1e-9);
        assertEquals("12.00 + 8.00 = 20.00", calc.formatExpression("+", 12, 8));
    }

    @Test
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> new Calculator().divide(10, 0));
    }

    @Test
    void testUnsupportedOperator() {
        assertThrows(IllegalArgumentException.class, () -> new Calculator().evaluate("^", 2, 3));
    }
}
