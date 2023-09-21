package linkedList;

/**
 * 707. {@link <a href="https://leetcode.com/problems/design-linked-list/description/">Design Linked List</a>}
 * <p>
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
 * A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
 * If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
 * <p>
 * Implement the MyLinkedList class:
 * <p>
 * MyLinkedList() Initializes the MyLinkedList object.
 * int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
 * void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
 * void addAtTail(int val) Append a node of value val as the last element of the linked list.
 * void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
 * void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
 * [[], [1], [3], [1, 2], [1], [1], [1]]
 * Output
 * [null, null, null, null, 2, null, 3]
 * <p>
 * Explanation
 * MyLinkedList myLinkedList = new MyLinkedList();
 * myLinkedList.addAtHead(1);
 * myLinkedList.addAtTail(3);
 * myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
 * myLinkedList.get(1);              // return 2
 * myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
 * myLinkedList.get(1);              // return 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= index, val <= 1000
 * Please do not use the built-in LinkedList library.
 * At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and deleteAtIndex.
 **/
public class MyLinkedList {
    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(2);
        obj.addAtTail(5);
        obj.addAtIndex(1, 4);
        obj.deleteAtIndex(1);
        System.out.print("element at index 1 = " + obj.get(1));
    }

    Node head;

    static class Node {
        int data;
        Node next = null;
    }

    public MyLinkedList() {
        head = new Node();
        head.data = 0;
        head.next = null;
    }

    public void addAtHead(int val) {
        Node node = new Node();
        node.data = val;
        node.next = head.next;
        head.next = node;
    }

    public int get(int index) {
        int data = -1;
        Node node = head.next;
        int currentIndex = 0;
        while (node != null) {
            if (currentIndex == index) {
                data = node.data;
                break;
            }
            node = node.next;
            currentIndex++;
        }
        return data;
    }

    public void addAtTail(int val) {
        Node node = head;
        while (node != null) {
            if (node.next == null) {
                Node newNode = new Node();
                newNode.data = val;
                node.next = newNode;
                break;
            }
            node = node.next;
        }

    }

    public void addAtIndex(int index, int val) {
        Node node = head;
        Node newNode = new Node();
        newNode.data = val;
        int currentIndex = 0;
        while (node != null) {
            if (currentIndex == index) {
                newNode.next = node.next;
                node.next = newNode;
            }
            currentIndex++;
            node = node.next;
        }

    }

    public void deleteAtIndex(int index) {
        Node node = head;
        int currentIndex = 0;
        while (node != null) {
            if (currentIndex == index) {
                if (node.next == null) {
                    node.next = null;
                } else {
                    node.next = node.next.next;
                }
                break;
            }
            currentIndex++;
            node = node.next;
        }
    }
}
