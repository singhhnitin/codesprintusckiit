class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);
        ListNode dummy = new ListNode(0), curr = dummy;
        int carry = 0;
        while (head != null || carry > 0) {
            int sum = carry + (head != null ? head.val * 2 : 0);
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            curr = curr.next;
            if (head != null) head = head.next;
        }
        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
