public class Main {
    public static void main(String[] args) throws StackUnderflowException {
        InfixToPostfixConverter obj = new InfixToPostfixConverter();
        System.out.println(obj.convert("(a+b)*(c-d)"));

    }
}
