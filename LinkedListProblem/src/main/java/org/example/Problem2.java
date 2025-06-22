package org.example;

import static org.example.Problem1.printList;
import static org.example.Problem1.Node;
public class Problem2 {
    public static void main(String[] args) {
        // Creating a sample singly linked list:
        // 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        System.out.println("-----------");
        printList(head);
        System.out.println("\n-----------");
        head = reverseKGroup(head, 3);

        printList(head);
    }

    static Node reverseKGroup(Node head, int k){
        if(head == null) return null;

        Node curr = head;
        Node newHead = null;
        Node tail = null;

        while (curr != null){
            Node groupHead = curr;
            Node prev = null;
            Node nextNode = null;
            int count = 0;

            // Reverse the nodes in the current group
            while (curr != null && count < k) {
                nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
                count++;
            }

            // If newHead is null, set it to the
            // last node of the first group
            if (newHead == null) {
                newHead = prev;
            }

            // Connect the previous group to the
            // current reversed group
            if (tail != null) {
                tail.next = prev;
            }

            // Move tail to the end of the
            // reversed group
            tail = groupHead;
        }

        return newHead;
    }
}
