package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ7569 {
    static int m, n, k;
    static int[][][] map;
    static boolean[][][] visited;
    static ArrayDeque<int[]> q = new ArrayDeque<>();
    static int[] dh = {1, -1, 0, 0, 0, 0};
    static int[] dr = {0, 0, 1, -1, 0, 0};
    static int[] dc = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[k][n][m];
        visited = new boolean[k][n][m];

        for (int i = 0; i < k; i++){
            for (int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1 && !visited[i][j][k]){
                        visited[i][j][k] = true;
                        q.addLast(new int[] {i, j, k});
                    }
                }
            }
        }
        bfs();

        int max = 0;
        for (int i = 0; i < k; i++){
            for (int j = 0; j < n; j++){
                for (int k = 0; k < m; k++){
                    if (map[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                    if (map[i][j][k] > max){
                        max = map[i][j][k];
                    }
                }
            }
        }
        System.out.println(max - 1);

    }
    static private void bfs(){
        while(!q.isEmpty()){
            int[] cur = q.removeFirst();
            for (int i = 0; i < 6; i++){
                int ddh = cur[0] + dh[i];
                int ddr = cur[1] + dr[i];
                int ddc = cur[2] + dc[i];
                if (ddh >= 0 && ddh < k && ddr >= 0 && ddr < n && ddc >= 0 && ddc < m){
                    if (map[ddh][ddr][ddc] == 0 && !visited[ddh][ddr][ddc]){
                        visited[ddh][ddr][ddc] = true;
                        q.addLast(new int[] {ddh, ddr, ddc});
                        map[ddh][ddr][ddc] = map[cur[0]][cur[1]][cur[2]] + 1;
                    }
                }
            }
        }

    }
}
