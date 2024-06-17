package miscellaneous.linkedList;

/**
 * 234. {@link <a href="https://leetcode.com/problems/binary-search/">Palindrome Linked List</a>}
 * <p>
 * Given the head of a singly linked list, return true if it is a
 * palindrome
 * or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,2,1]
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,2]
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 9
 * <p>
 * <p>
 * Follow up: Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode midNode = mid(head);
        ListNode leaftHead = reverse(midNode.next);
        while(leaftHead != null) {
            if (leaftHead.val != head.val) {
                return false;
            }
            leaftHead = leaftHead.next;
            head = head.next;
        }
        return true;
    }

    public ListNode mid(ListNode head) {
        ListNode fast = new ListNode();
        ListNode slow = new ListNode();
        fast.next = head;
        slow.next = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        ListNode next;
        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
