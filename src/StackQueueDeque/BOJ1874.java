package StackQueueDeque;

import java.io.*;
import java.util.*;

public class BOJ1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        for (int i = 0; i < n; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int next = 1;

        for (int i = 0; i < n; i++){

            while (next <= num[i]){
                stack.push(next);
                next++;
                res.append("+\n");
            }

            if (stack.peek() == num[i]){
                stack.pop();
                res.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(res);

    }
}
