import java.util.*;

public class PostfixEvaluator {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                int b = stack.pop(), a = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break; // integer division truncates toward zero
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] input1 = {"2", "3", "1", "*", "+", "9", "-"};
        String[] input2 = {"100", "200", "+", "2", "/", "5", "*", "7", "+"};
        System.out.println(evalRPN(input1)); // Output: -4
        System.out.println(evalRPN(input2)); // Output: 757
    }
}
