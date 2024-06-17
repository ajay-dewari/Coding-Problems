package miscellaneous.linkedList;

/**
 * 19. {@link <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">Remove Nth Node From End of List</a>}
 * <p>
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * <p>
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 * <p>
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * <p>
 * Follow up: Could you do this in one pass?
 * <p>
 * Solution explanation: {@link <a href="https://www.youtube.com/watch?v=Kncuqqg_I18">...</a>}
 **/
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode current = dummy;
        ListNode nth = dummy;
        for (int i = 1; i <= n + 1; i++) {
            current = current.next;
        }
        while (current != null) {
            current = current.next;
            nth = nth.next;
        }
        nth.next = nth.next.next;
        return dummy.next;
    }
}
