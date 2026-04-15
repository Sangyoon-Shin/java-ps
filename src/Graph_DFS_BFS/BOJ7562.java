package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ7562 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {2, 2, -2, -2, 1, 1, -1 ,-1};
    static int[] dc = {-1, 1, -1, 1, -2, 2, -2, 2};
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++){
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visited = new boolean[n][n];

            String[] s = br.readLine().split(" ");
            int curR = Integer.parseInt(s[0]);
            int curC = Integer.parseInt(s[1]);

            s = br.readLine().split(" ");
            int endR = Integer.parseInt(s[0]);
            int endC = Integer.parseInt(s[1]);

            bfs(curR, curC);
            System.out.println(map[endR][endC]);
        }
    }
    static private void bfs(int curR, int curC){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[curR][curC] = true;
        q.addLast(new int[] {curR, curC});

        while(!q.isEmpty()){
            int[] cur = q.removeFirst();
            for (int i = 0; i < 8; i++){
                int ddr = cur[0] + dr[i];
                int ddc = cur[1] + dc[i];
                if (ddr >= 0 && ddr < n && ddc >= 0 && ddc < n){
                    if (!visited[ddr][ddc]){
                        visited[ddr][ddc] = true;
                        q.addLast(new int[] {ddr, ddc});
                        map[ddr][ddc] = map[cur[0]][cur[1]] + 1;
                    }
                }
            }
        }

    }
}
