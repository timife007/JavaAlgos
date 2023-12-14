package algoexpert;

public class RearrangeLinkedList {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList rearrangeLinkedList(LinkedList head, int k){
        LinkedList low = null;
        LinkedList high = null;
        LinkedList highTracker = null;
        LinkedList lowTracker = null;
        LinkedList mid = null;
        LinkedList midTracker = null;

        while(head != null){
            if(head.value == k){
                if(mid == null){
                    mid = head;
                    midTracker = mid;
                }else{
                    midTracker.next = head;
                    midTracker = midTracker.next;
                }
            }else if(head.value < k){
                if(low == null){
                    low = head;
                    lowTracker = low;
                }else{
                    lowTracker.next = head;
                    lowTracker = lowTracker.next;
                }
            }else{
                if(high == null){
                    high = head;
                    highTracker = high;
                }else{
                    highTracker.next = head;
                    highTracker = highTracker.next;
                }
            }
            head = head.next;
        }
        if(midTracker != null){
            if(lowTracker != null && highTracker != null){
                lowTracker.next = mid;
                midTracker.next = high;
                highTracker.next = null;
                return low;
            }else if(lowTracker == null){
                midTracker.next = high;
                highTracker.next = null;
                return mid;
            }else {
                lowTracker.next = mid;
                midTracker.next = null;
                return low;
            }
        }else{
            if(lowTracker != null && highTracker != null){
                lowTracker.next = high;
                highTracker.next = null;
                return low;
            }else if(lowTracker == null){
                highTracker.next = null;
                return high;
            }else{
                lowTracker.next = null;
                return low;
            }
        }
    }
}
