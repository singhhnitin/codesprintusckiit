import java.io.*;
import java.util.*;

public class comp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String[] arr = br.readLine().trim().split("\\s+");
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));  // custom comparator
        if (arr[0].equals("0")) {
            System.out.println("0");
        } else {
            StringBuilder sb = new StringBuilder();
            for (String s : arr) {
                sb.append(s);
            }
            System.out.println(sb.toString());
        }
    }
}
