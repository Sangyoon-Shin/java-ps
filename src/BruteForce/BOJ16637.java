package BruteForce;

import java.util.*;
import java.io.*;

public class BOJ16637 {
    static int ans = Integer.MIN_VALUE;
    static ArrayList<Integer> num = new ArrayList<>();
    static ArrayList<Character> op = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String s = br.readLine();

        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if (cur == '+' || cur == '-' || cur == '*'){
                op.add(cur);
            } else {
                num.add(Character.getNumericValue(cur));
            }
        }
        dfs(0, num.get(0));
        System.out.println(ans);
    }
    public static void dfs(int opidx, int sum){
        if (opidx >= op.size()){
            ans = Math.max(ans, sum);
            return;
        }
        // 2가지 경우가 있음.
        // a + b * c 에서 a + b를 할 건지, a + (b * c)를 할건지
        int notChange = calc(sum, op.get(opidx), num.get(opidx + 1));
        dfs(opidx + 1, notChange);

        // 괄호로 다음 값을 먼저 묶어서 계산하는 경우
        if (opidx + 1 < op.size()){
            int change = calc(num.get(opidx + 1), op.get(opidx + 1), num.get(opidx + 2));
            int changeWithSum = calc(sum, op.get(opidx), change);
            dfs(opidx + 2, changeWithSum);
        }
    }
    public static int calc(int a, char operand, int b){
        if (operand == '+') {
            return a + b;
        } else if (operand == '-'){
            return a - b;
        } else {
            return a * b;
        }
    }
}
