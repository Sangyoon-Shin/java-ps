package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ1926 {
    static int[][] map;
    static boolean[][] visited;
    static int cnt = 0;
    static int drawCount = 0;
    static ArrayList<Integer> count = new ArrayList<>();
    static int n, m;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    drawCount++;
                    bfs(i, j);
                    count.add(cnt);
                    cnt = 0;
                }
            }
        }
        if (drawCount == 0){
            System.out.println(0);
            System.out.println(0);
        } else {
            System.out.println(drawCount);
            System.out.println(Collections.max(count));
        }
    }
    static private void bfs(int r, int c){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[r][c] = true;
        q.addLast(new int[] {r, c});
        cnt++;

        while (!q.isEmpty()){
            int[] cur = q.removeFirst();
            for (int i = 0; i < 4; i++){
                int ddr = cur[0] + dr[i];
                int ddc = cur[1] + dc[i];
                if (ddr >= 0 && ddr < n && ddc >= 0 && ddc < m){
                    if (map[ddr][ddc] == 1 && !visited[ddr][ddc]){
                        visited[ddr][ddc] = true;
                        q.addLast(new int[] {ddr, ddc});
                        cnt++;
                    }
                }
            }
        }
    }
}
