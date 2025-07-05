import java.util.*;

public class Dota2Senate {
    public static String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        // Initialize queues with indices of senators
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        // Simulate rounds
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIndex = radiant.poll();
            int dIndex = dire.poll();

            if (rIndex < dIndex) {
                // Radiant acts first, rejoin queue with updated index
                radiant.offer(rIndex + n);
            } else {
                // Dire acts first
                dire.offer(dIndex + n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        String senate1 = "RDD";
        System.out.println("Output 1: " + predictPartyVictory(senate1));  // Dire

        String senate2 = "RRDDD";
        System.out.println("Output 2: " + predictPartyVictory(senate2));  // Radiant
    }
}
