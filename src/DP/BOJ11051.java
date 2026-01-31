package DP;

import java.io.*;
import java.util.*;

public class BOJ11051 {
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int r = Integer.parseInt(s[1]);

        dp = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++){
            dp[i][1] = i;
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for (int i = 2; i <= n; i++){
            for (int j = 1; j < i; j++){
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;
            }
        }
        System.out.println(dp[n][r]);
    }
}
