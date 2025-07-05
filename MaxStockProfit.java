import java.util.Scanner;

public class MaxStockProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {
            int profit = prices[i] - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        if (maxProfit >= 2) {
            System.out.println(maxProfit);
        } else {
            System.out.println(0);
        }
    }
}
