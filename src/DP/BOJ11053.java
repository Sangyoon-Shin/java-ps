package DP;

import java.io.*;
import java.util.*;

public class BOJ11053 {
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        dp = new int[n];

        String[] s = br.readLine().split(" ");

        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        dp[0] = 1;
        for (int i = 1; i < n; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = Arrays.stream(dp).max().getAsInt();
        System.out.println(res);
    }
}
