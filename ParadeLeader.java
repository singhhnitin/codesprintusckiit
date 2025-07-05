class Node {
    int data; Node next;
    Node(int d) { data = d; next = null; }
}

public class ParadeLeader {
    public static Node getMiddleToEnd(Node head) {
        if (head == null) return null;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) System.out.print(", ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node createList(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]), curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] a1 = {1,2,3,4,5}, a2 = {1,2,3,4,5,6};
        printList(getMiddleToEnd(createList(a1)));
        printList(getMiddleToEnd(createList(a2)));
    }
}
