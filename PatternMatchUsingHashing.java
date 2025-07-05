import java.util.*;

public class PatternMatchUsingHashing {

    public static List<Integer> rabinKarp(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        
        int base = 256;        // Number of characters in the input alphabet
        int prime = 101;       // A prime number
        int n = text.length();
        int m = pattern.length();

        if (m > n) return result;

        int h = 1;
        for (int i = 0; i < m - 1; i++) {
            h = (h * base) % prime;
        }

        int pHash = 0; // Hash value for pattern
        int tHash = 0; // Hash value for text window

        // Initial hash computation
        for (int i = 0; i < m; i++) {
            pHash = (base * pHash + pattern.charAt(i)) % prime;
            tHash = (base * tHash + text.charAt(i)) % prime;
        }

        // Slide the pattern over text one by one
        for (int i = 0; i <= n - m; i++) {
            // If the hash values match, check the actual substring
            if (pHash == tHash) {
                if (text.substring(i, i + m).equals(pattern)) {
                    result.add(i);
                }
            }

            // Calculate hash for next window
            if (i < n - m) {
                tHash = (base * (tHash - text.charAt(i) * h) + text.charAt(i + m)) % prime;

                // Make sure hash is positive
                if (tHash < 0) {
                    tHash += prime;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String text = "thisresearchworkisunique";
        String pattern = "search";

        List<Integer> result = rabinKarp(text, pattern);
        System.out.println(result);  // Output: [6]
    }
}
