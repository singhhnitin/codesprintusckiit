import java.util.*;

public class EnchantmentFixer {
    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] count = new int[n + 1];
        int duplicate = -1, missing = -1;

        // Count occurrences
        for (int num : nums) {
            count[num]++;
        }

        // Identify duplicate and missing
        for (int i = 1; i <= n; i++) {
            if (count[i] == 0) {
                missing = i;
            } else if (count[i] == 2) {
                duplicate = i;
            }
        }

        return new int[]{duplicate, missing};
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 4};
        System.out.println(Arrays.toString(findErrorNums(nums1))); // [2, 3]

        int[] nums2 = {1, 1};
        System.out.println(Arrays.toString(findErrorNums(nums2))); // [1, 2]
    }
}
