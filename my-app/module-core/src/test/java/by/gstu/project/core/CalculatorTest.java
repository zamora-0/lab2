package by.gstu.project.core;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testArithmeticOperations() {
        Calculator calc = new Calculator();
        assertEquals(20.0, calc.add(12, 8), 1e-9);
        assertEquals(11.0, calc.subtract(15, 4), 1e-9);
        assertEquals(42.0, calc.multiply(6, 7), 1e-9);
        assertEquals(5.0, calc.divide(20, 4), 1e-9);
        assertEquals("12.00 + 8.00 = 20.00", calc.formatExpression("+", 12, 8));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        new Calculator().divide(10, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnsupportedOperator() {
        new Calculator().evaluate("^", 2, 3);
    }
}
