package DP;

import java.io.*;
import java.util.*;

public class BOJ1699 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        for (int i = 1; i <= (int)Math.sqrt(n); i++){
            dp[i * i] = 1; // 제곱수는 어차피 1번이니까 1로 초기화
        }

        for (int i = 1; i <= n; i++){
            if (dp[i] != 1){
                dp[i] = dp[i - 1] + 1; // 내 이전 숫자의 횟수에 + 1 더하는건 모두 가능
                for (int j = 1; j < i; j++){
                    dp[i] = Math.min(dp[i], dp[j] + dp[i - j]); // 위에서 초기화한 값이랑, 현재 값을 두수의 합으로 쪼갤 수 있는 경우 중 최소인 값 찾기
                }
            } else {
                continue;
            }
        }
        System.out.println(dp[n]);
    }

}
