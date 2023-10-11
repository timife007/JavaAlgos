package linkedlist.findlinkedlistitem;

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

    //Iterative approach to find item in linked-list
    boolean isItemPresent(int item, Node node){
        Node current = node;

        while(current != null){
            if(current.data == item) return true;
            current = current.next;
        }

        return false;
    }





    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        head = new Node(2);
        head.next = new Node(8);
        head.next.next = new Node(3);
        head.next.next.next = new LinkedList.Node(7);

        System.out.println(list.isItemPresent(0,null));
        System.out.println(list.isItemPresent(8,head));


    }

}
