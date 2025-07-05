import java.util.*;

public class KeypadCombinations {

    // Mapping of digits to letters
    private static final Map<Character, String> keypadMap = Map.of(
        '2', "abc",
        '3', "def",
        '4', "ghi",
        '5', "jkl",
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, String digits, int index) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String possibleLetters = keypadMap.get(digits.charAt(index));
        for (char c : possibleLetters.toCharArray()) {
            current.append(c);
            backtrack(result, current, digits, index + 1);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }

    // Test
    public static void main(String[] args) {
        KeypadCombinations generator = new KeypadCombinations();

        System.out.println(generator.letterCombinations("23"));
        System.out.println(generator.letterCombinations(""));
        System.out.println(generator.letterCombinations("2"));
    }
}
