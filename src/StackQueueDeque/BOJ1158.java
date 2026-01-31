package StackQueueDeque;

import java.io.*;
import java.util.*;

public class BOJ1158 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> table = new ArrayDeque<>();

        for (int i = 1; i <= n; i++){
            table.addLast(i);
        }

        StringBuilder res = new StringBuilder();
        res.append("<");

        while (table.size() > 1){
            for (int i = 0; i < k - 1; i++){
                table.addLast(table.removeFirst());
            }
            res.append(table.removeFirst() + ", ");
        }
        res.append(table.removeFirst() + ">");
        System.out.println(res);
    }

}
