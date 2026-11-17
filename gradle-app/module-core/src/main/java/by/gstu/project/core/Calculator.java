package by.gstu.project.core;

import java.util.Locale;

/**
 * Simple arithmetic calculator providing basic operations.
 */
public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0.0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return a / b;
    }

    public double evaluate(String op, double a, double b) {
        return switch (op) {
            case "+" -> add(a, b);
            case "-" -> subtract(a, b);
            case "*" -> multiply(a, b);
            case "/" -> divide(a, b);
            default -> throw new IllegalArgumentException("Unsupported operator: " + op);
        };
    }

    public String formatExpression(String op, double a, double b) {
        double result = evaluate(op, a, b);
        return String.format(Locale.US, "%.2f %s %.2f = %.2f", a, op, b, result);
    }
}
