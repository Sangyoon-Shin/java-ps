package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ2468 {
    static int[][] map;
    static boolean[][] visited;
    static int cnt = 0;
    static int maximum = 0;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        StringTokenizer st;
        int max = 0;
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (max < map[i][j]){
                    max = map[i][j];
                }
            }
        }

        for (int limit = 1; limit <= max + 1; limit++){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (!visited[i][j] && map[i][j] >= limit){
                        cnt++;
                        dfs(i, j, limit);
                    }
                }
            }
            if (cnt > maximum){
                maximum = cnt;
            }
            cnt = 0;
            visited = new boolean[n][n];
        }
        System.out.println(maximum);
    }
    static private void dfs(int r, int c, int limit){
        visited[r][c] = true;
        for (int i = 0; i < 4; i++){
            int ddr = r + dr[i];
            int ddc = c + dc[i];
            if (ddr >= 0 && ddr < n && ddc >= 0 && ddc < n){
                if (map[ddr][ddc] >= limit && !visited[ddr][ddc]){
                    dfs(ddr, ddc, limit);
                }
            }
        }
    }
}
