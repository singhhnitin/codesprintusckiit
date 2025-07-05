class ListNode {
    String val;
    ListNode next;
    ListNode(String val) { this.val = val; }
}

public class Main {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(""), prev = dummy;
        dummy.next = head;
        for (int i = 1; i < left; i++) prev = prev.next;
        ListNode curr = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode tmp = curr.next;
            curr.next = tmp.next;
            tmp.next = prev.next;
            prev.next = tmp;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
    }

    public static ListNode arrayToList(String[] arr) {
        ListNode dummy = new ListNode(""), curr = dummy;
        for (String s : arr) curr = curr.next = new ListNode(s);
        return dummy.next;
    }

    public static void main(String[] args) {
        String[] arr = {"Bread", "Eggs", "Milk", "Cheese", "Tomatoes"};
        ListNode head = arrayToList(arr);
        head = reverseBetween(head, 2, 4);
        printList(head);
    }
}
