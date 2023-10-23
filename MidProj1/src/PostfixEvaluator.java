import java.util.*;

public class PostfixEvaluator {
    public static double evaluatePostfixExpression(String postfixExpression) {
        Stack<Double> operandStack = new Stack<>();
        String[] tokens = postfixExpression.split(" ");

        for (String token : tokens) {
            if (isOperand(token)) {
                operandStack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                if (operandStack.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression: Not enough operands for operator.");
                }
                if ("$".equals(token)) {
                    double operand2 = operandStack.pop();
                    double operand1 = operandStack.pop();
                    double result = Math.pow(operand1, operand2);
                    operandStack.push(result);
                } else {
                    double operand2 = operandStack.pop();
                    double operand1 = operandStack.pop();
                    double result = applyOperator(token, operand1, operand2);
                    operandStack.push(result);
                }
            } else {
                throw new IllegalArgumentException("Invalid token: " + token);
            }
        }

        if (operandStack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression: Too many operands or operators.");
        }
        return operandStack.pop();
    }
    private static boolean isOperand(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private static boolean isOperator(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token) || "$".equals(token);
    }
    private static double applyOperator(String operator, double operand1, double operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
    }
}