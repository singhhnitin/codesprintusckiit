class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class TemperatureListSorter {
    
    public static ListNode sortByActualValues(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null) {
            if (curr.val < 0) {
                // Remove curr from its current position
                prev.next = curr.next;
                // Move curr to the front
                curr.next = head;
                head = curr;
                // Reset curr to prev's next
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return head;
    }

    // Helper to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(-2);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(-5);

        System.out.println("Original list:");
        printList(head);

        ListNode sorted = sortByActualValues(head);
        System.out.println("Sorted list by actual values:");
        printList(sorted);
    }
}
