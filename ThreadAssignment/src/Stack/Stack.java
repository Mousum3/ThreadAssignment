package Stack;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private final List<Integer> stack;
    private final int capacity;

    public Stack(int capacity) {
        this.stack = new ArrayList<>();
        this.capacity = capacity;
    }

    public synchronized void push(Integer value) throws InterruptedException {
        while (stack.size() >= capacity) {
            System.out.println("Stack is full.");
            wait();
        }
        stack.addLast(value);
        System.out.println("Produced: " + value);
        notifyAll();
    }

    public synchronized Integer pop() throws InterruptedException {
        while (stack.isEmpty()) {
            System.out.println("Stack is empty.");
            wait();
        }
        Integer value = stack.removeLast();
        System.out.println("Consumed: " + value);
        notifyAll();
        return value;
    }
    public void printer(){
        System.out.println(stack);
    }
}