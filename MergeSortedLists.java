class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class MergeSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1; l1 = l1.next;
            } else {
                current.next = l2; l2 = l2.next;
            }
            current = current.next;
        }
        current.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
    static ListNode buildList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]), current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        MergeSortedLists obj = new MergeSortedLists();

        ListNode list1 = buildList(new int[]{1, 2, 4});
        ListNode list2 = buildList(new int[]{1, 3, 4});
        ListNode merged = obj.mergeTwoLists(list1, list2);
        printList(merged);  // Output: 1 1 2 3 4 4

        list1 = buildList(new int[]{});
        list2 = buildList(new int[]{});
        merged = obj.mergeTwoLists(list1, list2);
        printList(merged);  // Output: (empty)

        list1 = buildList(new int[]{});
        list2 = buildList(new int[]{3, 4});
        merged = obj.mergeTwoLists(list1, list2);
        printList(merged);  // Output: 3 4
    }
}
