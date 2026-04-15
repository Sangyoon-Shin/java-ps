package DP;

import java.io.*;
import java.util.*;

public class BOJ15990 {
    static int mod = 1_000_000_009;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int max = 100001;
        int[][] dp = new int[max][4];

        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;

        for (int i = 4; i < max; i++){
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % mod;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % mod;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % mod;
        }

        for (int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(((long)dp[n][1] + dp[n][2] + dp[n][3]) % mod);
        }
    }
}
