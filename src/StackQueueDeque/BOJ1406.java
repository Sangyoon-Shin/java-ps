package StackQueueDeque;

import java.io.*;
import java.util.*;

public class BOJ1406 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 커서의 왼쪽, 오른쪽 나타내는 스택 두 개 만들기
        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < s.length(); i++){
            left.push(String.valueOf(s.charAt(i)));
        }

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("P")){
                String word = st.nextToken();
                // left에 push 해주기
                left.push(String.valueOf(word));
            } else {
                if (command.equals("L")){
                    if (left.isEmpty()){
                        continue;
                    } else {
                        // left -> right로 이동
                        right.push(left.pop());
                    }
                } else if (command.equals("D")){
                    if (right.isEmpty()){
                        continue;
                    } else {
                        // right -> left로 이동
                        left.push(right.pop());
                    }
                } else {
                    if (left.isEmpty()){
                        continue;
                    } else {
                        left.pop();
                    }
                }
            }
        }
        StringBuilder leftString = new StringBuilder();
        StringBuilder rightString = new StringBuilder();
        StringBuilder res = new StringBuilder();

        while (!left.isEmpty()){
            leftString.append(left.pop());
        }
        leftString.reverse();
        while (!right.isEmpty()){
            rightString.append(right.pop());
        }
        res.append(leftString).append(rightString);
        System.out.println(res);
    }
}
