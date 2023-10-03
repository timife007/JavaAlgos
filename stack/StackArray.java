package stack;

public class StackArray {
    private int maxSize;
    private int top;
    private int[] stack;

    public StackArray(int size){
        this.maxSize = size;
        this.stack = new int[maxSize];
        this.top = -1;

    }

    public void push(int item){
        stack[++top] = item;
    }

    public int pop(){
        return stack[top--];
    }

    public int peek(){
        return stack[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }
}
