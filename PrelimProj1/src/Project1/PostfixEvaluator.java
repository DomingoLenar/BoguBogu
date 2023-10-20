package Project1;

public class PostfixEvaluator {
    private final Operators execute;

    public PostfixEvaluator() {
        execute = new Operators();
    }

    public double evaluate(String prefixExpression) throws StackUnderflowException {
        Stack<Double> operandStack = new Stack<>();
        String[] charArray = prefixExpression.split(" ");
        execute.reverseArray(charArray);

        double result = 0;

        for (String s : charArray) {
            String token = String.valueOf(s);
            if (execute.isAnOperand(token)) {
                operandStack.push(Double.valueOf(token));

            } else {
                double secondOperand = operandStack.pop();
                double firstOperand = operandStack.pop();
                result = execute.evaluateOperands(firstOperand, secondOperand, token);
                operandStack.push(result);

            }
        }
        return result;
    }
}

