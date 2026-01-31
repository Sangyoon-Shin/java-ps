package StackQueueDeque;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        ArrayDeque<Integer> arr = new ArrayDeque<>();

        arr.addLast(1);
        arr.addLast(2);
        arr.addLast(3);
        arr.addLast(4);

        System.out.println(arr.peekLast());

    }
}
