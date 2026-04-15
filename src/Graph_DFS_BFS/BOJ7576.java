package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ7576 {
    static int[][] map;
    static boolean[][] visited;
    static int n, m;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static ArrayDeque<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[1]);
        m = Integer.parseInt(s[0]);

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1){
                    q.addLast(new int[] {i, j});
                }
            }
        }

        bfs();

        boolean allOne = true;
        int max = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (map[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                if (map[i][j] != 1){
                    allOne = false;
                }
                if (map[i][j] > max){
                    max = map[i][j];
                }
            }
        }
        if (!allOne){
            System.out.println(max - 1);
        } else {
            System.out.println(0);
        }
    }
    static private void bfs(){

        while (!q.isEmpty()){
            int[] cur = q.removeFirst();
            int curX = cur[0];
            int curY = cur[1];
            if (!visited[curX][curY]){
                visited[curX][curY] = true;
                for (int i = 0; i < 4; i++){
                    int ddr = curX + dr[i];
                    int ddc = curY + dc[i];
                    if (ddr >= 0 && ddr < n && ddc >= 0 && ddc < m){
                        if (map[ddr][ddc] == 0 && !visited[ddr][ddc]){
                            q.addLast(new int[] {ddr, ddc});
                            map[ddr][ddc] = map[curX][curY] + 1;
                        }
                    }
                }
            }
        }
    }
}
