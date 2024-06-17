package miscellaneous.linkedList;

/**
 * 21. {@link <a href="https://leetcode.com/problems/merge-two-sorted-lists/">Merge Two Sorted Lists</a>}
 * <p>
 * You are given the head of a singly linked-list. The list can be represented as:
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [1, 5 * 104].
 * 1 <= Node.val <= 1000
 * <p>
 * Solution Explanation
 * https://www.youtube.com/watch?v=rEYm4yLHSHQ
 * https://www.youtube.com/watch?v=xRYPjDMSUFw
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode mid = getMid(head);
        ListNode previous = null;
        ListNode current = getMid(head);
        ListNode temp;
        while (current != null) {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        ListNode first = head;
        ListNode second = previous;
        while (second.next != null) {
            temp = first.next;
            first.next = second;
            first = temp;
            temp = second.next;
            second.next = first;
            second = temp;
        }
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
