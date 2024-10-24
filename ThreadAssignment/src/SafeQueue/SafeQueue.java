package SafeQueue;

import java.util.LinkedList;

public class SafeQueue {
    private LinkedList<Integer> queue;

    public SafeQueue() {
        queue = new LinkedList<>();
    }

    public synchronized void enqueue(Integer value) {
        queue.addLast(value);
        //System.out.println("Enqueue: " + value);
        notifyAll();
    }

    public synchronized Integer dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Queue = empty");
            wait();
        }

        Integer value = queue.removeFirst();
        //System.out.println("Dequeue: " + value);
        return value;
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }
    public void printer(){
        System.out.println(queue);
    }
}
