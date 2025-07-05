import java.util.Scanner;

public class DecodedParenthesesCompact {

    public static String decodeMessage(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (balance > 0) {
                    result.append(c);
                }
                balance++;
            } else {
                balance--;
                if (balance > 0) {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(decodeMessage(s));
        scanner.close();
    }
}