package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA3307 {
    static int t, n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            n = Integer.parseInt(br.readLine());
            int[] num = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++){
                num[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[n];
            int res = 1;
            dp[0] = 1;

            for (int i = 1; i < n; i++){
                dp[i] = 1;
                for (int j = 0; j < i; j++){
                    if (num[i] >= num[j]){
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        res = Math.max(res, dp[i]);
                    }
                }
            }
            System.out.println("#" + tc + " " + res);
        }
    }
}
