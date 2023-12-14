package algoexpert;

public class SumOfLinkedList {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList sumOfLinkedLists(
            LinkedList linkedListOne, LinkedList linkedListTwo
    ) {
        LinkedList x = linkedListOne;
        LinkedList y = linkedListTwo;
        // Write your code here.
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        while(x != null){
            first.append(x.value);
            x = x.next;
        }
        while(y != null){
            second.append(y.value);
            y = y.next;
        }
        first.reverse();
        second.reverse();

        int value1 = Integer.parseInt(first.toString());
        int value2 = Integer.parseInt(second.toString());

        String sum = String.valueOf(value1 + value2);
        LinkedList result = new LinkedList(0);
        LinkedList pointer = result;
//        result.next = pointer;

        for(int i = sum.length() - 1; i >= 0; i--){
            LinkedList current = new LinkedList((int) sum.charAt(i));
            pointer.next = current;
            pointer = pointer.next;
        }
        pointer.next = null;
        return result;
    }

    public static void main(String[] args){
        StringBuilder  item = new StringBuilder();
        StringBuilder item2 = new StringBuilder();
        item.append("1742");
        item2.append("432");
        item.reverse();
        item2.reverse();
        int check = Integer.parseInt(item.toString()) + Integer.parseInt(item2.toString());
        String hange = String.valueOf(check);
        var convert = hange.charAt(1);
        System.out.println(Integer.valueOf(String.valueOf(hange.charAt(1))));
    }
}
