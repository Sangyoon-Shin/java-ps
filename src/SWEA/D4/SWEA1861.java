package SWEA.D4;

import java.io.*;
import java.util.*;

public class SWEA1861 {
    static int t, n;
    static int[][] map;
    static int[] dr = new int[] {-1, 1, 0, 0};
    static int[] dc = new int[] {0, 0, -1, 1};
    static int[] res;
    static int max, cnt;
    static ArrayList<Integer> candidate;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++){
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            candidate = new ArrayList<>();
            max = 0; cnt = 0;
            res = new int[n * n + 1];

            for (int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    dfs(i, j, i, j, 0);
                }
            }

            for (int i = 1; i <= n * n; i++){
                if (res[i] > cnt){
                    candidate.clear();
                    candidate.add(i);
                    max = i;
                    cnt = res[i];
                } else if (res[i] == cnt){
                    candidate.add(i);
                }
            }
            Collections.sort(candidate);
            System.out.println("#" + tc + " " + candidate.get(0) + " " + (cnt + 1));
        }
    }
    public static void dfs(int r, int c, int parentR, int parentC, int cnt){
        boolean canNotMove = true;
        for (int i = 0; i < 4; i++){
            int ddr = r + dr[i];
            int ddc = c + dc[i];
            if (ddr >= 0 && ddr < n && ddc >= 0 && ddc < n){
                if (map[r][c] + 1 == map[ddr][ddc]){
                    dfs(ddr, ddc, parentR, parentC, cnt + 1);
                    canNotMove = false;
                }
            }
        }
        if (canNotMove){
            res[map[parentR][parentC]] = cnt;
        }
    }
}
