package CorruptedList;

import java.util.ArrayList;

public class CorruptedList {
    private ArrayList<Integer> list = new ArrayList<>();

    public void adder(int element) {
        list.add(element);
    }

    public void remover() {
        if (!list.isEmpty()) {
            list.removeLast();
        }
    }

    public void printer() {
        System.out.println(list);
    }
}
