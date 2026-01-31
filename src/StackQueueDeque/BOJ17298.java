package StackQueueDeque;

import java.io.*;
import java.util.*;

public class BOJ17298 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nge = new int[n];
        int[] input = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++){
            nge[i] = -1;
        }

        for (int i = 0; i < n; i++){
            if (stack.isEmpty()){
                stack.addLast(i);
            } else {
                if (input[stack.peekLast()] < input[i]){
                    while(!stack.isEmpty() && input[stack.peekLast()] < input[i]){
                        nge[stack.removeLast()] = input[i];
                    }
                    stack.addLast(i);
                } else {
                    stack.addLast(i);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            sb.append(nge[i] + " ");
        }
        System.out.println(sb);
    }
}
