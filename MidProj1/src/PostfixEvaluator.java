/**
 * Class for postfix expression evaluation
 * October 23. 2023
 */

import java.util.*;

public class PostfixEvaluator {

    /**
     * This method evaluates a given postfix expression by iterating through its tokens (operands and operators).
     * It uses a stack to manage operands and performs arithmetic operations when operators are encountered.
     * If the expression is valid and well-formed, it returns the final result.
     * If the expression contains invalid tokens or doesn't have enough operands for
       an operator, it throws exceptions to report errors.
     */
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
    }//end of evaluatePostfixExpression

    /**
     *  This method checks whether a given token is a valid operand by attempting to convert it to a numeric value.
     *  If the conversion is successful, the token is considered an operand; otherwise, it is not.
     */
    private static boolean isOperand(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }//end of isOperand

    /**
     * This method checks whether a given token is a valid operator by comparing it to a predefined
     list of supported arithmetic operators (e.g., "+", "-", "*", "/", "$").
     * If the token matches one of these operators, it is considered a valid operator; otherwise, it is not.
     */
    private static boolean isOperator(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token) || "$".equals(token);
    }//end of isOperator

    /**
     * This method takes an operator and two operands as input and applies the specified arithmetic operation.
     */
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
    }//end of applyOperator
}//end of class