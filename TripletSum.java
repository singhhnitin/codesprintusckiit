import java.io.*;
import java.util.*;

public class TripletSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = Arrays.stream(br.readLine().split("\\s+"))
                          .mapToInt(Integer::parseInt)
                          .toArray();
        int target = Integer.parseInt(br.readLine().trim());
        System.out.println(hasTripletSum(arr, target) ? "true" : "false");
    }

    static boolean hasTripletSum(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == target) {
                    return true;
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return false;
    }
}
