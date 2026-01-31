package DP;

import java.io.*;
import java.util.*;

public class BOJ2193 {
    static long[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 규칙 세보면 1 1 2 3 5 8 11 19...
        // n번째 자리에 나올 이친수의 개수는 n - 1자리 숫자의 마지막 자리수가 0인지, 1인지에 따라 결정됨.

        // 90넣을때 int 배열 터진다...
        dp = new long[91];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
    }
}
