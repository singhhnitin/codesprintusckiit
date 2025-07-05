import java.util.*;

public class RobotRanking {
    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];
        // Pair of (score, index)
        int[][] scoreWithIndex = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            scoreWithIndex[i][0] = score[i];
            scoreWithIndex[i][1] = i;
        }

        // Sort by score in descending order
        Arrays.sort(scoreWithIndex, (a, b) -> b[0] - a[0]);

        for (int rank = 0; rank < n; rank++) {
            int index = scoreWithIndex[rank][1];
            if (rank == 0) {
                result[index] = "Gold Medal";
            } else if (rank == 1) {
                result[index] = "Silver Medal";
            } else if (rank == 2) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = String.valueOf(rank + 1);
            }
        }

        return result;
    }

    // Example usage
    public static void main(String[] args) {
        int[] score1 = {50, 80, 30, 100};
        System.out.println(Arrays.toString(findRelativeRanks(score1)));

        int[] score2 = {23, 45, 67, 12, 89};
        System.out.println(Arrays.toString(findRelativeRanks(score2)));
    }
}
