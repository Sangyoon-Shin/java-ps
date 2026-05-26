package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA3282 {
    static int t, n, limit;
    static int[][] dp;
    static int[] weight, value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            limit = Integer.parseInt(st.nextToken());

            weight = new int[n + 1];
            value = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());

                weight[i] = Integer.parseInt(st.nextToken());
                value[i] = Integer.parseInt(st.nextToken());
            }

            dp = new int[n + 1][limit + 1];

            for (int i = 1; i <= n; i++) {
                for (int w = 0; w <= limit; w++) {

                    // i번째 물건을 넣을 수 없는 경우
                    if (weight[i] > w) {
                        dp[i][w] = dp[i - 1][w];
                    }

                    // i번째 물건을 넣을 수 있는 경우
                    else {
                        dp[i][w] = Math.max(
                                dp[i - 1][w],
                                dp[i - 1][w - weight[i]] + value[i]
                        );
                    }
                }
            }

            System.out.println("#" + tc + " " + dp[n][limit]);
        }
    }
}