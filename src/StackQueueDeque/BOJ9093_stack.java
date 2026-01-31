package StackQueueDeque;

import java.io.*;
import java.util.*;

public class BOJ9093_stack {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            String sen = br.readLine();
            Stack<String> stack = new Stack<>();

            for (int j = 0; j < sen.length(); j++){
                if (sen.charAt(j) == ' '){
                    while (!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                } else {
                    stack.push(String.valueOf(sen.charAt(j)));
                }
            }
            while (!stack.isEmpty()){
                sb.append(stack.pop());
            }
            System.out.println(sb);
        }
    }
}
