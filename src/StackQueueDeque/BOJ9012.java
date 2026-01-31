package StackQueueDeque;

import java.io.*;
import java.util.*;

public class BOJ9012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            String s = br.readLine();
            Stack<String> stack = new Stack<>();
            // "(" 가 peek에 있을때 ")"를 만나야만 뽑을 수 있다.
            for (int j = 0; j < s.length(); j++){
                if (stack.isEmpty()){
                    stack.push(String.valueOf(s.charAt(j)));
                } else {
                    // '(' 랑 ')'에 따라 로직 달라짐
                    if (s.charAt(j) == '('){ // 이거면 무조건 집어넣어야함
                        stack.push(String.valueOf(s.charAt(j)));
                    } else { // '('인 경우엔 top 값이 ')'냐 '('에 따라 달라짐
                        if (stack.peek().charAt(0) == '('){
                            stack.pop();
                        } else {
                            stack.push(String.valueOf(s.charAt(j)));
                        }
                    }
                }
            }
            if (stack.isEmpty()){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
