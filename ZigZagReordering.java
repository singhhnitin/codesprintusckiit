import java.util.*;

public class ZigZagReordering {

    public static List<Integer> zigZagReorder(List<Integer> appointments) {
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = appointments.size() - 1;

        // Alternate picking from start and end
        while (start <= end) {
            result.add(appointments.get(start));
            start++;
            if (start <= end) {
                result.add(appointments.get(end));
                end--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example 1
        List<Integer> appointments1 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Output: " + zigZagReorder(appointments1));

        // Example 2
        List<Integer> appointments2 = Arrays.asList(10, 20, 30, 40);
        System.out.println("Output: " + zigZagReorder(appointments2));
    }
}
