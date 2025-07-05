import java.util.*;

public class RearrangeString {
    public static String rearrange(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                if (freq[i] > (s.length() + 1) / 2) {
                    return ""; // Not possible
                }
                maxHeap.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder result = new StringBuilder();
        while (maxHeap.size() > 1) {
            int[] first = maxHeap.poll();
            int[] second = maxHeap.poll();
            result.append((char) (first[0] + 'a'));
            result.append((char) (second[0] + 'a'));

            if (--first[1] > 0) maxHeap.offer(first);
            if (--second[1] > 0) maxHeap.offer(second);
        }

        if (!maxHeap.isEmpty()) {
            result.append((char) (maxHeap.poll()[0] + 'a'));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input1 = "aab";
        String input2 = "aaab";

        System.out.println("Input: " + input1 + " => Output: " + rearrange(input1));
        System.out.println("Input: " + input2 + " => Output: " + rearrange(input2));
    }
}
