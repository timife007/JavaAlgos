package linkedlist.reverselinkedlist;

// Java program for reversing the linked list

class LinkedList {

    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    /* Iterative approach to reverse the linked list */
    Node reverse(Node node)
    {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        node = prev;
        return node;
    }

    Node reverseRecursive(Node head){
        return recursion(head, null);
    }
    Node recursion(Node head, Node prev){
        if(head == null) return prev;

        Node next = head.next;
        head.next = prev;
        return recursion(next, head);
    }

    // prints content of double linked list
    void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        head = new Node(85);
        head.next = new Node(15);
        head.next.next = new Node(4);
        head.next.next.next = new Node(20);

        System.out.println("Given linked list");
        list.printList(head);
        head = list.reverse(head);
//        head = list.reverseRecursive(head);
        System.out.println();
        System.out.println("Reversed linked list ");
        list.printList(head);
    }
}

// This code has been contributed by Mayank Jaiswal

