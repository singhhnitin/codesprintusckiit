class DoublyListNode {
    int val;
    DoublyListNode next, prev;
    DoublyListNode(int val) { this.val = val; }
}

public class RemoveCursed {
    public DoublyListNode removeNodes(DoublyListNode head, int target) {
        DoublyListNode curr = head;
        while (curr != null) {
            if (curr.val == target) {
                if (curr.prev != null) curr.prev.next = curr.next;
                else head = curr.next;
                if (curr.next != null) curr.next.prev = curr.prev;
            }
            curr = curr.next;
        }
        return head;
    }
}

