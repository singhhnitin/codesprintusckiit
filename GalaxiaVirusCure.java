import java.util.*;

public class GalaxiaVirusCure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of patients and vaccines
        int[] vaccines = new int[n];
        int[] patients = new int[n];

        for (int i = 0; i < n; i++)
            vaccines[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            patients[i] = sc.nextInt();

        Arrays.sort(vaccines);
        Arrays.sort(patients);

        boolean canCureAll = true;
        for (int i = 0; i < n; i++) {
            if (vaccines[i] <= patients[i]) {
                canCureAll = false;
                break;
            }
        }

        System.out.println(canCureAll ? "yes" : "no");
    }
}
