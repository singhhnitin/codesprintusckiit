import java.util.HashMap;
import java.util.Scanner;

public class EmotionalBalanceChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (isEmotionallyBalanced(input)) {
            System.out.println("Aashriya smiles: Emotional balance found.");
        } else {
            System.out.println("Aashriya wonders: These thoughts were scattered.");
        }
    }

    private static boolean isEmotionallyBalanced(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();

        
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        int expectedFreq = freqMap.values().iterator().next();

        for (int freq : freqMap.values()) {
            if (freq != expectedFreq) {
                return false;
            }
        }

        return true;
    }
}
