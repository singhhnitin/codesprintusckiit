import java.util.*;

public class SecretArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] nge = new int[N];
        Arrays.fill(nge, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                nge[i] = arr[stack.peek()];
            }
            stack.push(i);
        }

        Map<Integer, Integer> nseMap = new HashMap<>();
        stack.clear();

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                nseMap.put(arr[i], arr[stack.peek()]);
            } else {
                nseMap.put(arr[i], -1);
            }
            stack.push(i);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int nextGreater = nge[i];
            if (nextGreater == -1) {
                result.append("-1");
            } else {
                result.append(nseMap.getOrDefault(nextGreater, -1));
            }
            if (i < N - 1) {
                result.append(" ");
            }
        }
        System.out.println(result.toString());

        scanner.close();
    }
}