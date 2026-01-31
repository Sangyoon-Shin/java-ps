package StackQueueDeque;

import java.io.*;
import java.util.*;

public class BOJ10866 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Deque<Integer> deque = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push_back")){
                int v = Integer.parseInt(input[1]);
                deque.addLast(v);
            } else if (input[0].equals("push_front")){
                int v = Integer.parseInt(input[1]);
                deque.addFirst(v);
            } else if (input[0].equals("pop_front")){
                if (!deque.isEmpty()){
                    System.out.println(deque.removeFirst());
                } else {
                    System.out.println(-1);
                }
            } else if (input[0].equals("pop_back")){
                if (!deque.isEmpty()){
                    System.out.println(deque.removeLast());
                } else {
                    System.out.println(-1);
                }
            } else if (input[0].equals("size")){
                System.out.println(deque.size());
            } else if (input[0].equals("empty")){
                if (deque.isEmpty()){
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (input[0].equals("front")){
                if (!deque.isEmpty()){
                    System.out.println(deque.peekFirst());
                } else {
                    System.out.println(-1);
                }
            } else {
                if (!deque.isEmpty()){
                    System.out.println(deque.peekLast());
                } else {
                    System.out.println(-1);
                }
            }
        }

    }
}
