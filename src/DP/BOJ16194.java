package DP;

import java.io.*;
import java.util.*;

public class BOJ16194 {
    static int[] dp;
    static int[] price;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        price = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++){
            price[i] = Integer.parseInt(s[i]);
        }

        dp = new int[n + 1];
        dp[1] = price[0];

        for (int i = 2; i <= n; i++){
            dp[i] = price[i - 1];
            for (int j = 1; j < i; j++){
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }
        }
        System.out.println(dp[n]);
    }
}
