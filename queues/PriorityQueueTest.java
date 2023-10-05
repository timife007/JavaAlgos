package queues;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {


    /**
     * PriorityQueues do not necessarily print their items in sorted order.
     * The reason for this behavior is that System.out.println simply calls
     * the toString() method of the PriorityQueue, which returns a string
     * representation of the elements as they are stored in the underlying data structure.
     * This representation does not guarantee a sorted order when printed because
     * the PriorityQueue may use a data structure like a binary heap to efficiently
     * maintain the priority order of elements.
     * This doesn't mean they're not in the order which the comparator states.
     */
    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("Zealot");
        pq.add("Zealot");
        pq.add("Geek");
        pq.add("For");
        pq.add("Timife");
        pq.add("Geek");
        pq.add("For");
        pq.add("Zainab");
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }

}
