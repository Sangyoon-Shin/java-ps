package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ1012 {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean visited[][];
    static int map[][];
    static int n;
    static int m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++){
            String[] s = br.readLine().split(" ");
            m = Integer.parseInt(s[0]);
            n = Integer.parseInt(s[1]);
            int k = Integer.parseInt(s[2]);

            map = new int[n][m];
            visited = new boolean[n][m];

            for (int j = 0; j < k; j++){
                s = br.readLine().split(" ");
                int x = Integer.parseInt(s[0]);
                int y = Integer.parseInt(s[1]);
                map[y][x] = 1;
            }

            int cnt = 0;
            for (int r = 0; r < n; r++){
                for (int c = 0; c < m; c++){
                    if (map[r][c] == 1 && !visited[r][c]){
                        cnt++;
                        dfs(r, c);
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    static private void dfs(int r, int c){
        visited[r][c] = true;
        for (int i = 0; i < 4; i++){
            int ddr = r + dr[i];
            int ddc = c + dc[i];
            if (ddr >= 0 && ddr < n && ddc >= 0 && ddc < m){
                if (map[ddr][ddc] == 1 && !visited[ddr][ddc]){
                    dfs(ddr, ddc);
                } else {
                    continue;
                }
            }
        }
    }
}
