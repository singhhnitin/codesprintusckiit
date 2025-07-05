
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class AddTwoNumbers {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // Dummy head for result list
        ListNode current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;  // Update carry for next iteration
            current.next = new ListNode(sum % 10);  // Create new node with current digit
            current = current.next;
        }

        return dummyHead.next;
    }
    public void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = solution.addTwoNumbers(l1, l2);
        solution.printList(result); // Output: 7 -> 0 -> 8
    }
}
