package linkedlist.getnode;

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

    Node findNodeAtIndex(Node head, int index){
        if(head == null) return null;
        Node current = head;
        int tracker = -1;
        while(current != null){
            tracker++;
            if(tracker == index){
                return current;
            }
            current = current.next;
        }
        return null;
    }


    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        head = new Node(2);
        head.next = new Node(8);
        head.next.next = new Node(3);
        head.next.next.next = new Node(7);

        System.out.println(list.findNodeAtIndex(head, 0).data);


    }

}
