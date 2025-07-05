class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    public boolean detectAndRemoveCycle(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle using Floyd’s algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Cycle detected
                removeCycle(head, slow);
                return true;
            }
        }

        // No cycle
        return true;
    }

    private void removeCycle(ListNode head, ListNode meetingPoint) {
        ListNode ptr1 = head;
        ListNode ptr2 = meetingPoint;

        // Step 2: Find start of the cycle
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // Step 3: Find the last node in the cycle and break the loop
        ListNode loopStart = ptr1;
        ListNode temp = loopStart;
        while (temp.next != loopStart) {
            temp = temp.next;
        }
        temp.next = null; // Remove cycle
    }

    // Utility method to create a cycle for testing
    public void createCycle(ListNode head, int pos) {
        if (pos == 0) return;
        ListNode tail = head;
        ListNode cycleNode = null;
        int index = 1;
        while (tail.next != null) {
            if (index == pos) cycleNode = tail;
            tail = tail.next;
            index++;
        }
        // Connect last node to cycle start
        tail.next = cycleNode;
    }
}
