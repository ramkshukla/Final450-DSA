package org.example;

public class Problem1 {
     static class Node{
        int data;
        Node next;
        Node(int new_data){
            this.data = new_data;
            this.next = null;
        }
    }

    public static Node reverseList(Node head){
        Node curr = head;
        Node prev = null;
        Node next = null;

        while (curr != null){
            // store next
            next = curr.next;

            // Reverse current node's next pointer
            curr.next = prev;

            // Move pointers one position ahead
            prev = curr;
            curr = next;
        }
        return  prev;
    }
    public static void printList(Node node){
        while (node != null){
            System.out.print(" " + node.data);
            node = node.next;
        }
    }
    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.print("Given Linked list:");
        printList(head);

        head = reverseList(head);

        System.out.print("\nReversed Linked List:");
        printList(head);
    }
}
