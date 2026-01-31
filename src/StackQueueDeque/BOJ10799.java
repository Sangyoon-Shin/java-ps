package StackQueueDeque;

import java.io.*;
import java.util.*;

public class BOJ10799 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        ArrayDeque<String> stack = new ArrayDeque<>();

        int cnt = 0;

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){ // 일단 '('면 레이저이든 막대기든 stack에 넣고
                stack.addLast(String.valueOf(s.charAt(i)));
            } else if (s.charAt(i) == ')' && s.charAt(i - 1) == '('){ // () 인접해있으면 레이저
                stack.removeLast();
                cnt += stack.size();
            } else if (s.charAt(i) == ')'){
                stack.removeLast();
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}
