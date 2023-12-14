package algoexpert;

public class RemoveLinkedListDup {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        // Write your code here.
        LinkedList tracker = linkedList;
        LinkedList iterator = tracker.next;

        while(iterator != null){
            while(iterator.value == tracker.value){
                iterator = iterator.next;
            }
            tracker.next = iterator;
            iterator = iterator.next;
        }


        return linkedList;
    }

    public static void main(String[] args){
        StringBuilder check = new StringBuilder();
        check.append(1).append("x");
        Integer.valueOf(String.valueOf(check));
        int a = 444;
        System.out.println(String.valueOf(a));

    }
}
