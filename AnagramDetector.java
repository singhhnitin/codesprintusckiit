import java.util.*;

public class AnagramDetector {
    
    public static List<Integer> findAnagrams(String logStream, String pattern) {
        List<Integer> result = new ArrayList<>();
        if (logStream.length() < pattern.length()) return result;

        int[] patternFreq = new int[26];
        int[] windowFreq = new int[26];

        // Build frequency of the pattern
        for (char ch : pattern.toCharArray()) {
            patternFreq[ch - 'a']++;
        }

        // Initialize the first window
        for (int i = 0; i < pattern.length(); i++) {
            windowFreq[logStream.charAt(i) - 'a']++;
        }

        // Check first window
        if (Arrays.equals(patternFreq, windowFreq)) {
            result.add(0);
        }

        // Slide the window
        for (int i = pattern.length(); i < logStream.length(); i++) {
            // Remove leftmost char of the previous window
            windowFreq[logStream.charAt(i - pattern.length()) - 'a']--;
            // Add new char to current window
            windowFreq[logStream.charAt(i) - 'a']++;

            if (Arrays.equals(patternFreq, windowFreq)) {
                result.add(i - pattern.length() + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String logStream1 = "cbaebabacd";
        String pattern1 = "abc";
        System.out.println(findAnagrams(logStream1, pattern1));  // Output: [0, 6]

        String logStream2 = "abab";
        String pattern2 = "ab";
        System.out.println(findAnagrams(logStream2, pattern2));  // Output: [0, 1, 2]
    }
}
