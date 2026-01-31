package DP;

import java.io.*;
import java.util.*;

public class BOJ11050 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int r = Integer.parseInt(s[1]);

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++){
            dp[i][i] = 1; // 1) n개 중에서 n개 뽑는 경우 => 1가지
            dp[i][0] = 1; // 2) n개 중에서 0개 뽑는 경우 => 1가지
            dp[i][1] = i; // 3) n개 중에서 1개 뽑는 경우 => n가지
        }

        for (int i = 2; i <= n; i++){
            for (int j = 1; j < i; j++){
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        System.out.println(dp[n][r]);
    }
}
