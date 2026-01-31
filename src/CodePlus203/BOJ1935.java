package CodePlus203;

import java.io.*;
import java.util.*;

public class BOJ1935 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        double[] value = new double[26];

        for (int i = 0; i < n; i++){
            value[i] = Integer.parseInt(br.readLine());
        }

        ArrayDeque<Double> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){ // 피연산자 나오면 push
                stack.addLast(value[s.charAt(i) - 'A']);
            } else { // 연산자 나오면 위에서 두 개 뽑고 걔네 계산한 값 push
                // 35/ 면 3/5다.
                double second = stack.removeLast();
                double first = stack.removeLast();
                if (s.charAt(i) == '+'){
                    stack.addLast(first + second);
                } else if (s.charAt(i) == '-'){
                    stack.addLast(first - second);
                } else if (s.charAt(i) == '*'){
                    stack.addLast(first * second);
                } else {
                    stack.addLast(first / second);
                }
            }
        }
        double res = stack.removeLast();
        System.out.printf("%.2f", res);
    }
}
