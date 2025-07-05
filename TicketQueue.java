public class TicketQueue {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) time += Math.min(tickets[i], tickets[k]);
            else time += Math.min(tickets[i], tickets[k] - 1);
        }
        return time;
    }

    public static void main(String[] args) {
        TicketQueue tq = new TicketQueue();
        int[] tickets1 = {2, 3, 2};
        int k1 = 2;
        System.out.println(tq.timeRequiredToBuy(tickets1, k1)); // Output: 6

        int[] tickets2 = {5, 1, 1, 1};
        int k2 = 0;
        System.out.println(tq.timeRequiredToBuy(tickets2, k2)); // Output: 8
    }
}
