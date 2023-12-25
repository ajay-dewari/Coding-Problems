package practical;

import linkedList.ListNode;

import java.util.List;

public class LinkedListPractical {

    private boolean isPalindromeLinkedList(ListNode head) {
        ListNode mid = midOfLinkedList(head);
        ListNode leftHead = reverse(mid.next);
        while (leftHead != null) {
            if (leftHead.val != head.val) {
                return false;
            }
            leftHead = leftHead.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return head;
    }

    private ListNode reverseKTimes(ListNode head, int k) {
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        int count = 0;
        while (current != null && count <= k) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            count++;
        }
        if (next != null) {
            head.next = reverseKTimes(next, k);
        }
        return previous;
    }

    private ListNode midOfLinkedList(ListNode head) {
        ListNode slow = new ListNode();
        ListNode fast = new ListNode();
        slow.next = head;
        fast.next = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next.next;
        }
        return slow;
    }

    private ListNode mergeSortedLinkedList(ListNode list1, ListNode list2) {
        ListNode sortedList = new ListNode();
        ListNode current = sortedList;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        current.next = list1 != null ? list1 : list2;
        return sortedList.next;
    }

    private ListNode mergeKSortedNLinkedList(List<ListNode> list) {
        ListNode firstlist = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            firstlist = mergeSortedLinkedList(firstlist, list.get(i));
        }
        return firstlist;
    }

    private ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null ) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        temp.next = null;
        ListNode leftSide = sortList(head);
        ListNode rightSide = sortList(slow);
        return mergeSortedLinkedList(leftSide, rightSide);
    }
}

