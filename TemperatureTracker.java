import java.util.*;

public class TemperatureTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        
        while (n-- > 0) {
            String[] input = sc.nextLine().split(" ");
            switch (input[0]) {
                case "PUSH":
                    int x = Integer.parseInt(input[1]);
                    stack.push(x);
                    if (minStack.isEmpty() || x <= minStack.peek()) minStack.push(x);
                    break;
                case "POP":
                    if (!stack.isEmpty()) {
                        if (stack.peek().equals(minStack.peek())) minStack.pop();
                        stack.pop();
                    }
                    break;
                case "MIN":
                    System.out.println(minStack.isEmpty() ? "EMPTY" : minStack.peek());
                    break;
            }
        }
    }
}
