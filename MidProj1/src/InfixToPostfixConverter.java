import java.util.Stack;
public class InfixToPostfixConverter {
    private final Operators execute;

    public InfixToPostfixConverter() {
        execute = new Operators();
    }

    /*
     #TODO: method enhance implementation is possible to hold all possible cases
     * Problem: it does not give correct postfix when user input an infix that is factorized/simplified form (i.e., a-b(c+d))
     * Possible solution: use helper method to transform simplified infix to general infix expression or construct entirely new method that is capable converting any infix to postfix expression
     */
    public String convert(String infixExpression) throws StackUnderflowException {
        StringBuilder postfixExpression = new StringBuilder();
        Stack<String> operatorStack = new Stack<>();

        for (int i = 0; i < infixExpression.length(); i++) {
            String token = String.valueOf(infixExpression.charAt(i));
            if (execute.isAnOperand(token)) {
                postfixExpression.append(token);
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
                    while (!operatorStack.isEmpty()){ // get remaining operators (handle infix w parenthesis)
                        postfixExpression.append(operatorStack.pop());
                    }
                }
            }
        }

        while (!operatorStack.isEmpty()){ // get rest operators in stack (infix w/o parenthesis)
            postfixExpression.append(operatorStack.pop());
        }

        return postfixExpression.toString();
    }
}