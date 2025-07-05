import java.util.Scanner;

public class MovementSegments {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        String log = scanner.nextLine();
        scanner.close();

        int count = 0;
        boolean inSegment = false;

        for (int i = 0; i < log.length(); i++) {
            if (log.charAt(i) == '1') {
                if (!inSegment) {
                    
                    count++;
                    inSegment = true;
                }
            } else {
                inSegment = false;
            }
        }

        System.out.println(count);
    }
}
