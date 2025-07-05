class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class PackageColorSorter {

    public static ListNode sortColors(ListNode head) {
        // Dummy heads for 0s, 1s, and 2s lists
        ListNode zeroD = new ListNode(0), oneD = new ListNode(0), twoD = new ListNode(0);
        // Current tails of these lists
        ListNode zero = zeroD, one = oneD, two = twoD;

        // Traverse original list and distribute nodes
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == 0) {
                zero.next = curr;
                zero = zero.next;
            } else if (curr.val == 1) {
                one.next = curr;
                one = one.next;
            } else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }

        // Connect three sublists together
        zero.next = oneD.next != null ? oneD.next : twoD.next;
        one.next = twoD.next;
        two.next = null;

        // Return new head
        return zeroD.next;
    }

    // Helper to print list
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
        ListNode head = new ListNode(2);
        head.next = new ListNode(0);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(0);

        System.out.println("Original list:");
        printList(head);

        ListNode sorted = sortColors(head);
        System.out.println("Sorted by color:");
        printList(sorted);
    }
}
1.class first{
    public static void main (String args[]) {
        System.out.print("//write your text");
    }
}