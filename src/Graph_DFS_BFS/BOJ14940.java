package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ14940 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2){
                    map[i][j] = -2;
                }
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (map[i][j] == -2){
                    map[i][j] = 0;
                    bfs(i, j);
                }
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (map[i][j] != 0 && !visited[i][j]){
                    map[i][j] = -1;
                }
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    static private void bfs(int r, int c){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[] {r, c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] cur = q.removeFirst();
            for (int i = 0; i < 4; i++){
                int ddr = cur[0] + dr[i];
                int ddc = cur[1] + dc[i];
                if (ddr >= 0 && ddr < n && ddc >= 0 && ddc < m){
                    if (map[ddr][ddc] == 1 && !visited[ddr][ddc]){
                        q.addLast(new int[] {ddr, ddc});
                        visited[ddr][ddc] = true;
                        map[ddr][ddc] = map[cur[0]][cur[1]] + 1;
                    }
                }
            }
        }
    }
}
