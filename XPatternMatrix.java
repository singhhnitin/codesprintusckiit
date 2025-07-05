import java.util.Scanner;

public class XPatternMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int mainDiagVal = 1;
        int antiDiagVal = n;

        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();

            for (int j = 0; j < n; j++) {
                if (i == j && i + j == n - 1) {
            
                    row.append(mainDiagVal);
                } else if (i == j) {
                    row.append(mainDiagVal);
                } else if (i + j == n - 1) {
                    row.append(antiDiagVal);
                } else {
                    row.append("-");
                }

                if (j != n - 1) row.append(" ");
            }

            System.out.println(row);

            mainDiagVal++;
            antiDiagVal--;
        }

        sc.close();
    }
}
