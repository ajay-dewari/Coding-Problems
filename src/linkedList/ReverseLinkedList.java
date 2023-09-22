package linkedList;

/**
 * 206. {@link <a href="https://leetcode.com/problems/reverse-linked-list/">Reverse Linked List</a>}
 * <p>
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * <p>
 * Example 2:
 * Input: head = [1,2]
 * Output: [2,1]
 * <p>
 * Example 3:
 * Input: head = []
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 * <p>
 * <p>
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 **/
public class ReverseLinkedList {

    public static void main(String[] args) {
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (null != current) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    /**
     * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
     * <p>
     * Input
     * head =
     * [1,2,3,4,5]
     * k = 3
     * Output
     * [3,2,1,4,5]
     * <p>
     * Input
     * head =
     * [1,2,3,4,5]
     * k =
     * 2
     * Output
     * [2,1,4,3,5]
     **/
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        int count = 0;
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }
        return prev;
    }
}
