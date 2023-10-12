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

    //Iterative approach time O(N) and space O(1)
    Integer findNodeAtIndex(Node head, int index){
        if(head == null) return null;
        Node current = head;
        int tracker = 0;
        while(current != null){
            if(tracker == index){
                return current.data;
            }
            tracker++;
            current = current.next;
        }
        return null;
    }

    //Recursive approach time O(N) and space O(N)
    Integer findNodeRecursive(Node head, int index){
        if(head == null) return null;
        if(index == 0){
            return head.data;
        }
        return findNodeRecursive(head.next, index - 1);
    }


    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        head = new Node(2);
        head.next = new Node(8);
        head.next.next = new Node(3);
        head.next.next.next = new Node(7);

        System.out.println(list.findNodeRecursive(head, 2));


    }

}
