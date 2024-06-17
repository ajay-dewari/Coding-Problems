package miscellaneous.linkedList;

/**
 * 25. {@link <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/">Reverse Nodes in k-Group</a>}
 * <p>
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * <p>
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 * <p>
 * <p>
 * Follow-up: Can you solve the problem in O(1) extra memory space?
 **/
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode current = dummy, next = dummy, prev = dummy;
        int count = 0;
        while (current.next != null) {
            current = current.next;
            count++;
        }

        while (count >= k) {
            current = prev.next;
            next = current.next;
            for (int i = 1; i < k; i++) {
                current.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = current.next;
            }
            prev = current;
            count -= k;
        }
        return dummy.next;
    }
}
