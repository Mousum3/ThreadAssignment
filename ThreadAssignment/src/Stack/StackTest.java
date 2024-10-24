package Stack;
import java.sql.SQLOutput;
import java.util.Random;

public class StackTest {
    private static Stack stack = new Stack(10);
    private static Random random = new Random();

    public static void main(String[] args) {
        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                produce();
            }
        });
        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                consume();
            }
        });

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void produce() {
        for (int i = 0; i < 100; i++) {
            int value = random.nextInt(100) + 1;
            try {
                stack.push(value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private static void consume() {
        for (int i = 0; i < 100; i++) {
            try {
                stack.pop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

