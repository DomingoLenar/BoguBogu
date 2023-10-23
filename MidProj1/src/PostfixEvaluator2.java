import java.util.Stack;

public class PostfixEvaluator {
    public int evaluatePostfix(String exp) {
        Stack<Integer> stack = new Stack<>();
        char c = ' ';
        char characters;
        int n;
        int operand1 = 0;
        int operand2 = 0;
        int ansHolder = 0;

        System.out.printf("%-20s%-20s%-20s%-20s%-20s", "Symbol", "Operand 1", "Operand 2", "Value", "Operand Stack");

        for (int i = 0; i < exp.length(); i++) {
            c = exp.charAt(i);
            characters = c;
            int ans = 0;
            if (c == ' ') {
                continue;
            } else if (Character.isDigit(c)) {
                n = 0;
                while (Character.isDigit(c)) {
                    n = n * 10 + (int) (c - '0');
                    i++;
                    c = exp.charAt(i);
                }
                i--;
                stack.push(n);
            } else {
                operand1 = stack.pop();
                operand2 = stack.pop();
                ansHolder = ans;
                switch (c) {
                    case '+':
                        ans = stack.push(operand2 + operand1);
                        ansHolder = ans;
                        break;
                    case '-':
                        ans = stack.push(operand2 - operand1);
                        ansHolder = ans;
                        break;
                    case '*':
                        ans = stack.push(operand2 * operand1);
                        ansHolder = ans;
                        break;
                    case '/':
                        ans = stack.push(operand2 / operand1);
                        ansHolder = ans;
                        break;
                    case '$':
                        ans = stack.push((int) Math.pow(operand2, operand1));
                        ansHolder = ans;
                        break;
                }
            }
            System.out.printf("\n%-20c%-20d%-20d%-20d", characters, operand2, operand1, ansHolder);
            operandStackPrint(stack);
        }
        return stack.pop();
    }

    public static void operandStackPrint(Stack<Integer> stack) {
        if(stack.empty()){
            return;
        }
        int top = stack.peek();
        stack.pop();
        operandStackPrint(stack);
        System.out.print(top + ", ");
        stack.push(top);
    }
}