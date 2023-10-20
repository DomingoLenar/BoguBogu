package Project1;

public class InfixToPostfixConverter {

    private final Operators execute;

    public InfixToPostfixConverter() {
        execute = new Operators();
    }

    public String convert(String infixExpression) throws StackUnderflowException {
        StringBuilder postfixExpression = new StringBuilder();
        Stack<String> operatorStack = new Stack<>();

        for (int i = 0; i < infixExpression.length(); i++) {
            String token = String.valueOf(infixExpression.charAt(i));
            if (execute.isAnOperand(token)) {
                postfixExpression.append(token);
            } else {
                if (!token.equals(")")) {
                    while (!operatorStack.isEmpty() && !token.equals("(") && execute.precedence(operatorStack.peek(), token)) {
                        postfixExpression.append(operatorStack.pop()).append(" ");
                    }
                    operatorStack.push(token);
                } else {
                    while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                        postfixExpression.append(operatorStack.pop()).append(" ");
                    }
                    if (!operatorStack.isEmpty() && operatorStack.peek().equals("(")) {
                        operatorStack.pop();
                    }
                }
            }
        }

        while (!operatorStack.isEmpty()) {
            postfixExpression.append(operatorStack.pop()).append(" ");
        }

        return postfixExpression.toString().trim();
    }

}

