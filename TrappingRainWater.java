import java.util.*;

public class TrappingRainWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // number of buildings
        int[] height = new int[n];
        
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        int waterTrapped = trap(height);
        System.out.println(waterTrapped);
    }

    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int trappedWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    trappedWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    trappedWater += rightMax - height[right];
                }
                right--;
            }
        }

        return trappedWater;
    }
}
