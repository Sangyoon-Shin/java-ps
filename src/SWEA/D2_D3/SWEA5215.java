package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA5215 {
    static int t, n, limit, maxScore;
    static int[][] info;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            limit = Integer.parseInt(st.nextToken());
            maxScore = 0;

            info = new int[n][2];
            for (int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int cal = Integer.parseInt(st.nextToken());
                info[i][0] = score;
                info[i][1] = cal;
            }

            for (int i = 0; i < n; i++){
                dfs(info[i][0], info[i][1], i); // 지금까지 점수, 지금까지 칼로리, 시작지점
            }
            System.out.println("#" + tc + " " + maxScore);
        }
    }
    public static void dfs(int score, int cal, int idx){
        if (cal <= limit){
            maxScore = Math.max(maxScore, score);
        }
        if (cal < limit){
            for (int i = idx + 1; i < n; i++){
                dfs(score + info[i][0] , cal + info[i][1], i);
            }
        }
    }
}
