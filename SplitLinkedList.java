import java.util.*;

public class SplitLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode[] splitListToParts(ListNode head, int k) {
        int totalLength = 0;
        ListNode current = head;
        while (current != null) {
            totalLength++;
            current = current.next;
        }
        int baseSize = totalLength / k;
        int extra = totalLength % k;
        ListNode[] parts = new ListNode[k];
        current = head;

        for (int i = 0; i < k; i++) {
            ListNode partHead = current;
            int partSize = baseSize + (i < extra ? 1 : 0);

            for (int j = 0; j < partSize - 1; j++) {
                if (current != null) current = current.next;
            }

            if (current != null) {
                ListNode nextPart = current.next;
                current.next = null;
                current = nextPart;
            }

            parts[i] = partHead;
        }

        return parts;
    }
    public static ListNode createList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }
    public static void printParts(ListNode[] parts) {
        for (ListNode part : parts) {
            if (part == null) {
                System.out.print("[] ");
            } else {
                List<Integer> list = new ArrayList<>();
                while (part != null) {
                    list.add(part.val);
                    part = part.next;
                }
                System.out.print(list + " ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] values = scanner.nextLine().split(" ");
        int[] tasks = Arrays.stream(values).mapToInt(Integer::parseInt).toArray();

        int k = Integer.parseInt(scanner.nextLine());

        ListNode head = createList(tasks);
        ListNode[] parts = splitListToParts(head, k);

        printParts(parts);
    }
}
