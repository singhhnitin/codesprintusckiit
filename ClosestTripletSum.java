import java.util.*;

public class ClosestTripletSum {
    public static int threeSumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int closestSum = arr[0] + arr[1] + arr[2]; // initialize to the first triplet

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                int diff = sum - target;
                int absDiff = Math.abs(diff);
                int closestDiff = Math.abs(closestSum - target);

                if (absDiff < closestDiff ||
                    (absDiff == closestDiff && sum > closestSum)) {
                    closestSum = sum;
                }

                if (diff > 0) {
                    right--;
                } else if (diff < 0) {
                    left++;
                } else {
                    // Exact match found
                    return sum;
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int target = sc.nextInt();
        System.out.println(threeSumClosest(arr, target));
    }
}
