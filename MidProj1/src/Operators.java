public class Operators {

    // Method to check if a given character is an operand (letter or digit)
    public boolean isAnOperand(String expressionChar) {
        char token = expressionChar.charAt(0);
        return Character.isLetterOrDigit(token);

    } // end of isAnOperand method

    // Method to check if a given character is an operator (+, -, *, /, or ^)
    public boolean isAnOperator(String expressionChar) {
        char token = expressionChar.charAt(0);
        return token == '^' || token == '/' || token == '*' || token == '+' || token == '-';

    } // end of isAnOperator method

    // Method to determine operator precedence between two characters
    public boolean precedence(String stackChar, String expressionChar) {
        char stackToken = stackChar.charAt(0);
        char expressionToken = expressionChar.charAt(0);
        return ((stackToken == '^' || stackToken == '*' || stackToken == '/') && (expressionToken == '+' || expressionToken == '-'));

    } // end of precedence method

    // Method to perform an operation on two operands with a given operator
    public double evaluateOperands(double firstOperand, double secondOperand, String token) {
        switch (token) {
            case "^" -> { return (int) Math.pow(firstOperand, secondOperand); }
            case "*" -> { return firstOperand * secondOperand; }
            case "/" -> { return firstOperand / secondOperand; }
            case "+" -> { return  firstOperand + secondOperand; }
            case "-" -> { return firstOperand - secondOperand; }
            default -> { return 0; }
        }

    } // end of evaluateOperands method

    // Method to validate a mathematical expression for matching parentheses and operator placement
    public boolean validateString(String expression) {
        int openParenthesis = 0;
        int closedParenthesis = 0;

        for (int i = 0; i < expression.length(); i++) {
            if (isAnOperator(String.valueOf(expression.charAt(i))) && isAnOperator(String.valueOf(expression.charAt(i + 1))))
                return true;
            if (expression.charAt(i) == '(') openParenthesis++;
            if (expression.charAt(i) == ')') closedParenthesis++;
        }
        return openParenthesis != closedParenthesis;

    } // end of validateString method

    // Method to reverse the order of characters in a given expression
    public String reverseExpression(String expression) {
        StringBuilder reversedExpression = new StringBuilder();

        for (int i = expression.length() - 1; i >= 0; i--) {
            reversedExpression.append(expression.charAt(i));
        }
        return reversedExpression.toString();

    } // end of reverseExpression method

    // Method to reverse the order of elements in an array
    public void reverseArray(String[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            String temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }

    } // end of reverseArray method

} // end of class Operators