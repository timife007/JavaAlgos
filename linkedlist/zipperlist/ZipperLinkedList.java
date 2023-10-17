package linkedlist.zipperlist;

class LinkedList {

    static Node head1;
    static Node head2;

    static class Node {

        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    //Iterative approach time O(N), space O(1)
    Node zipperList(Node head1, Node head2){
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        Node current1 = head1.next;
        Node current2 = head2;
        Node tail = head1;
        int counter = 0;

        while(current1 != null && current2 != null){
            if(counter % 2 == 1){
                tail.next = current1;
                current1 = current1.next;
            }else {
                tail.next = current2;
                current2 = current2.next;
            }
            tail = tail.next;
            counter++;
        }
        if(current1 == null){
            tail.next = current2;
        }
        if(current2 == null){
            tail.next = current1;
        }

        return head1;
    }

    //Recursive approach time O(N), space O(N)
    Node zipperRecursive(Node head1, Node head2){
        if(head1 == null && head2 == null) return null;
        if(head1 ==  null) return head2;
        if(head2 == null) return head1;
        Node next1 = head1.next;
        Node next2 = head2.next;

        head1.next = head2;
        head2.next = zipperRecursive(next1,next2);
        return head1;

    }

    void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        head1 = new Node(2);
        head1.next = new Node(8);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(7);

        head2 = new Node(5);
        head2.next = new Node(9);
        head2.next.next = new Node(12);
        head2.next.next.next = new Node(11);

        list.printList(list.zipperRecursive(head1,head2));

    }
}
