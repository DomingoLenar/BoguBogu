import java.util.Stack;
public class InfixToPostfixConverter {

    // Create an instance of the Operators class to handle operator-related operations.
    private final Operators execute;

    // Constructor for InfixToPostfixConverter class.
    public InfixToPostfixConverter() {
        execute = new Operators(); // Initialize the 'execute' field with a new instance of the Operators class.
    }

    /*
     * Converts an infix expression to a postfix expression.
     * This method takes an infix expression in the form of a space-separated string
     * and converts it into a postfix expression using a stack-based algorithm.
     */
    public String convert(String infixString) throws StackUnderflowException {
        StringBuilder postfixExpression = new StringBuilder();
        String[] infixExpression = infixString.split(" ");
        Stack<String> operatorStack = new Stack<>();

        for (int i = 0; i < infixExpression.length; i++) {
            String token = String.valueOf(infixExpression[i]);
            if (execute.isAnOperand(token)) {
                postfixExpression.append(token+" ");
            } else {
                while (!operatorStack.isEmpty() && execute.precedence(operatorStack.peek(), token)) {
                    postfixExpression.append(operatorStack.pop());
                }
                if (!token.equals(")")) {
                    operatorStack.push(token);
                } else {
                    while (!operatorStack.peek().equals("(")) {
                        postfixExpression.append(operatorStack.pop());
                    }
                    operatorStack.pop();
                    while (!operatorStack.isEmpty()){ // Get the remaining operators (handling infix with parenthesis).
                        postfixExpression.append(operatorStack.pop());
                    }
                }
            }
        }

        while (!operatorStack.isEmpty()){ // Get the remaining operators in the stack (infix without parenthesis).
            postfixExpression.append(operatorStack.pop());
        }

        return postfixExpression.toString();
    } // End of convert method
} // End of class