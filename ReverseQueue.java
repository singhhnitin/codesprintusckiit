import java.util.*;

public class ReverseQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of citizens
        int n = sc.nextInt();

        // Array to store citizen IDs
        int[] queue = new int[n];

        // Read citizen IDs
        for (int i = 0; i < n; i++) {
            queue[i] = sc.nextInt();
        }

        // Print in reverse order
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(queue[i] + " ");
        }
    }
}
