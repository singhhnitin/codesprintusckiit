import java.util.Arrays;

public class PowerTokenGame {
    public static int maxScore(int[] tokens, int power) {
        Arrays.sort(tokens); // Sort tokens to try smallest and largest values efficiently
        int score = 0, maxScore = 0;
        int left = 0, right = tokens.length - 1;

        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left++];
                score++;
                maxScore = Math.max(maxScore, score);
            } else if (score > 0) {
                power += tokens[right--];
                score--;
            } else {
                break; // Can't play any move
            }
        }

        return maxScore;
    }

    public static void main(String[] args) {
        int[] tokens1 = {20, 50, 70, 120};
        int power1 = 90;
        System.out.println("Max Score: " + maxScore(tokens1, power1)); // Output: 2

        int[] tokens2 = {10, 30, 60, 90};
        int power2 = 100;
        System.out.println("Max Score: " + maxScore(tokens2, power2)); // Output: 3
    }
}
