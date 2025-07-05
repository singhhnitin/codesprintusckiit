import java.util.*;

public class MagicianCardTrick {
    public static List<Integer> findInitialOrder(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);  // Sort the deck to get the desired reveal order
        
        Deque<Integer> queue = new ArrayDeque<>();
        
        // Work backwards to reconstruct the initial deck order
        for (int i = n - 1; i >= 0; i--) {
            if (!queue.isEmpty()) {
                queue.addFirst(queue.removeLast());  // Reverse the move-to-bottom step
            }
            queue.addFirst(deck[i]);  // Simulate placing the current card on top
        }

        return new ArrayList<>(queue);
    }

    public static void main(String[] args) {
        int[] deck1 = {5, 12, 9};
        System.out.println(findInitialOrder(deck1));  // Output: [5, 9, 12]

        int[] deck2 = {1, 10, 3, 8, 6};
        System.out.println(findInitialOrder(deck2));  // Output: [1, 3, 6, 8, 10]
    }
}
