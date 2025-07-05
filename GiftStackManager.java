import java.util.*;

public class GiftStackManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        Stack<String> stack = new Stack<>();
        Map<String, Integer> freqMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String commandLine = sc.nextLine();
            String[] parts = commandLine.split(" ");
            String command = parts[0];
            
            if (command.equals("PUSH")) {
                String label = parts[1];
                stack.push(label);
                freqMap.put(label, freqMap.getOrDefault(label, 0) + 1);
            } else if (command.equals("POP")) {
                if (!stack.isEmpty()) {
                    String top = stack.pop();
                    freqMap.put(top, freqMap.get(top) - 1);
                    if (freqMap.get(top) == 0) {
                        freqMap.remove(top);
                    }
                }
            } else if (command.equals("COUNT")) {
                if (stack.isEmpty()) {
                    System.out.println("EMPTY");
                } else {
                    String top = stack.peek();
                    System.out.println(freqMap.get(top));
                }
            }
        }
        sc.close();
    }
}
