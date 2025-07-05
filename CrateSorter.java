import java.util.*;

public class CrateSorter {
    public static List<Integer> sortByFrequency(int[] crates) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : crates) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        // Create a list of unique numbers
        List<Integer> nums = new ArrayList<>(freq.keySet());

        // Sort by: frequency descending, then value ascending
        nums.sort((a, b) -> {
            int fa = freq.get(a), fb = freq.get(b);
            if (fa != fb) {
                return Integer.compare(fb, fa);
            } else {
                return Integer.compare(a, b);
            }
        });

        // Build result by repeating each number according to its frequency
        List<Integer> result = new ArrayList<>();
        for (int x : nums) {
            for (int i = 0; i < freq.get(x); i++) {
                result.add(x);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] crates = new int[n];
        for (int i = 0; i < n; i++) {
            crates[i] = sc.nextInt();
        }

        List<Integer> sorted = sortByFrequency(crates);
        for (int x : sorted) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
