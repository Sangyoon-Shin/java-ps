package DP;

import java.io.*;
import java.util.*;

public class BOJ11052 {
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] price = new int[n];
        dp = new int[n + 1];

        String[] s = br.readLine().split(" ");
        for (int i = 0 ; i < n; i++){
            price[i] = Integer.parseInt(s[i]);
        }

        dp[1] = price[0];

        for (int i = 2; i <= n; i++){
            dp[i] = price[i - 1];
            for (int j = 1; j < i; j++){
                dp[i] = Math.max(dp[i], dp[j] + dp[i - j]);
            }
        }

        System.out.println(dp[n]);
    }
}
