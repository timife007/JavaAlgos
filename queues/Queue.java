package queues;

public class Queue {
    private int maxSize;
    private long[] queueArray;
    private int front;
    private int rear;

    public Queue(int size){
        this.maxSize = size;
        this.queueArray = new long[size];
        this.front = 0;
        this.rear = -1;
    }

    public void insert(long item){ //put item at rear of the queue.
        //If rear is at the last index of the queue, reset rear index.
        if(rear == maxSize - 1){
            rear = -1;
        }
        queueArray[++rear] = item;
    }

    public long remove(){ //take item from front of queue.
        long temp = queueArray[front++]; //shift the front index to the next after saving the initial front value
        if(front == maxSize){
            front = 0;
        }
        return temp;
    }

    public long peek(){
        return queueArray[front];
    }

    public boolean isEmpty(){
        return (rear +  1 == front || front + maxSize - 1 == rear);
    }

    public boolean isFull(){
        return (rear + 2 == front || (front + maxSize - 2 == rear));
    }
}
