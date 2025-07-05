import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public static int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelSet = new HashSet<>();
        
       
        for (char c : jewels.toCharArray()) {
            jewelSet.add(c);
        }

        int count = 0;
        // Count how many stones are jewels
        for (char c : stones.toCharArray()) {
            if (jewelSet.contains(c)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        
        String jewels1 = "aA";
        String stones1 = "aAAbbbb";
        System.out.println("Output: " + numJewelsInStones(jewels1, stones1)); // Output: 3

        
        String jewels2 = "z";
        String stones2 = "ZZ";
        System.out.println("Output: " + numJewelsInStones(jewels2, stones2)); // Output: 0
    }
}
