import java.util.*;

public class DungeonMaxScore {
    public static int maxScore(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(0);

        for (int i = 1; i < n; i++) {
            // Remove indices out of window (i - k)
            while (!deque.isEmpty() && deque.peekFirst() < i - k) {
                deque.pollFirst();
            }

            // The best score to reach i is from the max dp in window + nums[i]
            dp[i] = dp[deque.peekFirst()] + nums[i];

            // Maintain decreasing order in deque for dp[]
            while (!deque.isEmpty() && dp[i] >= dp[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, -2, -5, 7, -6, 4};
        int k1 = 2;
        System.out.println("Output 1: " + maxScore(nums1, k1));  // Output: 10

        int[] nums2 = {2, 3, -2, 5, -1, 4};
        int k2 = 3;
        System.out.println("Output 2: " + maxScore(nums2, k2));  // Output: 14
    }
}
