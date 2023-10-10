package linkedlist.sumlinkedlist;

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


    //Iterative approach; Time O(N), Space O(1)
    int sumLinkedList(Node node){
        if(node == null) return 0;
        int sum = 0;
        Node current = node;
        while(current != null){
            sum += current.data;
            current = current.next;
        }
        return sum;
    }
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        head = new Node(2);
        head.next = new Node(8);
        head.next.next = new Node(3);
        head.next.next.next = new Node(7);

        System.out.println(list.sumLinkedList(head));

    }
}
