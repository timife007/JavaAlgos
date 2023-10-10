package linkedlist;

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

    //Iteration
    void linkedListValues(Node node){
        Node current = node;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    //Recursion
    void linkedListRecurse(Node node){
        if(node == null) return;

        System.out.println(node.data);
        linkedListValues(node.next);
    }

    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        head = new Node(85);
        head.next = new Node(15);
        head.next.next = new Node(4);
        head.next.next.next = new Node(20);  

        System.out.println("Given linked list");
        list.linkedListValues(head);
        list.linkedListRecurse(head);
    }

}
