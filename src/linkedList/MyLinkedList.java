package linkedList;

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
