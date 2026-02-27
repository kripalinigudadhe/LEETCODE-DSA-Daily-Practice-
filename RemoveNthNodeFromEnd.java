import java.util.*;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RemoveNthNodeFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove nth node
        slow.next = slow.next.next;

        return dummy.next;
    }

    // -------- PSVM --------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of nodes:");
        int size = sc.nextInt();

        if (size == 0) {
            System.out.println("[]");
            sc.close();
            return;
        }

        System.out.println("Enter elements:");
        ListNode head = new ListNode(sc.nextInt());
        ListNode current = head;

        for (int i = 1; i < size; i++) {
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }

        System.out.println("Enter n:");
        int n = sc.nextInt();

        head = removeNthFromEnd(head, n);

        // Print updated list
        System.out.println("Updated List:");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

        sc.close();
    }
}