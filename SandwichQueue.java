import java.util.*;

public class SandwichQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of students and sandwiches

        Queue<Integer> students = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            students.offer(sc.nextInt()); // student preferences
        }

        int[] sandwiches = new int[n];
        for (int i = 0; i < n; i++) {
            sandwiches[i] = sc.nextInt(); // sandwich stack (top is sandwiches[0])
        }

        int index = 0;
        int count = 0;

        while (!students.isEmpty() && count < students.size()) {
            if (students.peek() == sandwiches[index]) {
                students.poll();  // student gets sandwich
                index++;          // move to next sandwich
                count = 0;        // reset unmatched counter
            } else {
                students.offer(students.poll()); // student moves to back
                count++; // increase count of unmatched attempts
            }
        }

        System.out.println(students.size());
    }
}
