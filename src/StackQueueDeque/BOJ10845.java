package StackQueueDeque;

import java.io.*;
import java.util.*;

public class BOJ10845 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")){
                int value = Integer.parseInt(st.nextToken());
                q.addLast(value);
            } else if (command.equals("pop")){
                if (!q.isEmpty()){
                    System.out.println(q.removeFirst());
                } else {
                    System.out.println(-1);
                }
            } else if (command.equals("size")){
                System.out.println(q.size());
            } else if (command.equals("empty")){
                if (q.isEmpty()){
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (command.equals("front")){
                if (!q.isEmpty()){
                    System.out.println(q.getFirst());
                } else {
                    System.out.println(-1);
                }
            } else {
                if (!q.isEmpty()){
                    System.out.println(q.getLast());
                } else {
                    System.out.println(-1);
                }
            }
        }
    }

}
