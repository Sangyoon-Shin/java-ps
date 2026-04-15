package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ2178 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s[] = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++){
            String row = br.readLine();
            for (int j = 0; j < m; j++){
                map[i][j] = row.charAt(j) - '0';
            }
        }
        bfs(0, 0);
        System.out.println(map[n - 1][m - 1]);
    }
    static private void bfs(int r, int c){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[] {r, c});
        visited[r][c] = true;
        while (!q.isEmpty()){
            int[] cur = q.removeFirst();
            for (int i = 0; i < 4; i++){
                int ddr = cur[0] + dr[i];
                int ddc = cur[1] + dc[i];
                if (ddr >= 0 && ddr < n && ddc >= 0 && ddc < m){
                    if (map[ddr][ddc] != 0 && !visited[ddr][ddc]){
                        visited[ddr][ddc] = true;
                        map[ddr][ddc] = map[cur[0]][cur[1]] + 1;
                        q.addLast(new int[] {ddr, ddc});
                    }
                }
            }
        }
    }
}
