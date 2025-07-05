import java.util.Scanner;

public class MarathonWaveChart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int totalPrinted = 0;

      
        if (n > 10) {
            System.out.println("Abhik’s marathon journey intensifies! Let’s see his progress chart:");
        }

        int maxWidth = (n - 1) * 4 + 1;

        for (int day = 1; day <= n; day++) {
            StringBuilder line = new StringBuilder();
            if (day % 2 == 1) {
                
                for (int i = 1; i <= day; i++) {
                    line.append(i);
                    totalPrinted++;
                    if (i != day) line.append("   "); 
                }
            } else {
                
                for (int i = day; i >= 1; i--) {
                    line.append(i);
                    totalPrinted++;
                    if (i != 1) line.append("   ");
                }
            }

            
            int lineLength = line.length();
            int leftPadding = (maxWidth - lineLength) / 2;

           
            System.out.printf("%" + (leftPadding + lineLength) + "s%n", line.toString());
        }

       
        System.out.println("Total numbers printed: " + totalPrinted);
        sc.close();
    }
}
