import java.util.*;

public class VowelPatientFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Set<String> seen = new HashSet<>();
        List<String> result = new ArrayList<>();

      
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

     
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            if (vowels.contains(name.charAt(0)) && !seen.contains(name)) {
                seen.add(name);
                result.add(name);
            }
        }

       
        System.out.println(result.size());
        for (String name : result) {
            System.out.print(name + " ");
        }

        scanner.close();
    }
}
