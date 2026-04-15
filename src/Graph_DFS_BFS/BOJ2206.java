package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ2206 {
    static int n, m;
    static int[][] map;
    static boolean[][][] visited;
    static int[][][] dist;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean isPossible = false;
    static ArrayDeque<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        visited = new boolean[n][m][2];
        map = new int[n][m];
        dist = new int[n][m][2];

        for (int i = 0; i < n; i++){
            String cur = br.readLine();
            for (int j = 0; j < m; j++){
                map[i][j] = cur.charAt(j) - '0';
            }
        }

        dist[0][0][0] = 1;
        q.addLast(new int[] {0, 0, 0});
        visited[0][0][0] = true;

        System.out.println(bfs());
    }

    public static int bfs(){

        while (!q.isEmpty()){
            int[] cur = q.removeFirst();
            if (cur[0] == n - 1 && cur[1] == m - 1){
                return dist[cur[0]][cur[1]][cur[2]];
            }
            for (int i = 0; i < 4; i++){
                int ddr = cur[0] + dr[i];
                int ddc = cur[1] + dc[i];
                int isBroken = cur[2];

                if (ddr < 0 || ddr >= n || ddc < 0 || ddc >= m) {
                    continue;
                }
                if (map[ddr][ddc] == 0 && !visited[ddr][ddc][isBroken]){ // 1. 다음 이동할 곳이 벽이 아니고, 방문한적이 없으면
                    dist[ddr][ddc][isBroken] = dist[cur[0]][cur[1]][isBroken] + 1;
                    visited[ddr][ddc][isBroken] = true;
                    q.addLast(new int[] {ddr, ddc, isBroken});
                } else if (map[ddr][ddc] == 1 && isBroken == 0 && !visited[ddr][ddc][1]){ // 2. 다음 이동할 곳이 벽인데, 지금까지 부순적이 없고 방문 전이면
                    dist[ddr][ddc][1] = dist[cur[0]][cur[1]][isBroken] + 1; // 벽을 안부순 이전 노드의 거리에서 + 1
                    visited[ddr][ddc][1] = true;
                    q.addLast(new int[] {ddr, ddc, 1});
                }
            }
        }
        return -1;
    }
}
