package stack;

public class StackArray {
    private final int maxSize;
    private int top;
    private final int[] stack;

    public StackArray(int size) {
        this.maxSize = size;
        this.stack = new int[maxSize];
        this.top = -1;

    }

    public void push(int item) {
        stack[++top] = item; //increment top then add the item at the new position
    }

    public int pop() {
        return stack[top--]; //return the top item, then reduce the top index.
    }

    public int peek() {
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }
}

class StackApp {

    public static void main(String[] args) {
        StackArray theStack = new StackArray(10);
        theStack.push(20);
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        while (!theStack.isEmpty()) {
            long value = theStack.pop();
            System.out.println(value);
            System.out.println("  ");
        }
        System.out.println(" ");


        StackArray newStack = new StackArray(3);
        for(int i = 0; i <= 3; i++) {
            if (!newStack.isFull()) {
                newStack.push(20 + i);
            } else {
                System.out.println("Can't insert, stack is full");
            }
        }
    }

}
