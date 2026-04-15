package DP;

import java.io.*;
import java.util.*;

public class BOJ1912 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        dp[0] = arr[0];

        for (int i = 1; i < n; i++){
            dp[i] = arr[i];
            dp[i] = Math.max(dp[i], dp[i - 1] + arr[i]);
        }

        int res = Arrays.stream(dp).max().getAsInt();
        System.out.println(res);
    }
}
