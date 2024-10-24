package CorruptedList;

public class Runner{
    public static void main(String[] args) {
        CorruptedList corruptedList = new CorruptedList();

        Runnable taskAdder = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    corruptedList.adder(i);
                }
            }
        };

        Runnable taskRemove = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500; i++) {
                    corruptedList.remover();
                }
            }
        };


        Thread thread1 = new Thread(taskAdder);
        Thread thread2 = new Thread(taskRemove);
        Thread thread3 = new Thread(taskAdder);
        Thread thread4 = new Thread(taskRemove);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        corruptedList.printer();
    }
}

