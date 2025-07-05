import java.util.*;

public class FirstNonRepeatingCharacterStream {
    public static String firstNonRepeating(String s) {
        int[] freq = new int[26]; // Frequency of each character
        Queue<Character> q = new LinkedList<>(); // Queue to maintain stream order
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++; // Increment frequency
            q.add(ch);        // Add to queue

            // Remove repeated characters from the front
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.poll();
            }

            // Append result
            if (q.isEmpty()) {
                result.append('#');
            } else {
                result.append(q.peek());
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Example 1
        String s1 = "aabc";
        System.out.println(firstNonRepeating(s1)); // Output: a#bb

        // Example 2
        String s2 = "zz";
        System.out.println(firstNonRepeating(s2)); // Output: z#
    }
}
