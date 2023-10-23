public class Main {
    public static void main(String[] args) throws StackUnderflowException {
        // Create an instance of InfixToPostfixConverter
        InfixToPostfixConverter obj = new InfixToPostfixConverter();

        // Test the conversion of an infix expression to postfix
        // The result should be "a b + c d - *"
        System.out.println(obj.convert("(a+b)*(c-d)"));
    }
}
