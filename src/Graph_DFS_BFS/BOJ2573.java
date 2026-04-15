package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ2573 {
    static int[][] map;
    static int n, m;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static ArrayDeque<int[]> q;
    static boolean[][] visited;
    static int groupCnt;
    static boolean isValid;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while (true){
            year++;
            visited = new boolean[n][m];
            q = new ArrayDeque<>();
            isValid = false;
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    if (map[i][j] > 0 && !visited[i][j]){
                        visited[i][j] = true;
                        q.addLast(new int[] {i, j});
                    }
                }
            }
            bfs();

            visited = new boolean[n][m];
            groupCnt = 0;

            dfsAll();

            if (groupCnt >= 2){
                System.out.println(year);
                break;
            } else {
                for (int i = 0; i < n; i++){
                    for (int j = 0; j < m; j++){
                        if (map[i][j] > 0){
                            isValid = true;
                        }
                        if (map[i][j] < 0){
                            map[i][j] = 0;
                        }
                    }
                }
            }
            if (!isValid){
                System.out.println(0);
                break;
            }
        }
    }
    public static void bfs(){
        boolean isNewGroup = true;
        while (!q.isEmpty()){
            int[] cur = q.removeFirst();
            int cnt = 0;
            for (int i = 0; i < 4; i++){
                int ddr = cur[0] + dr[i];
                int ddc = cur[1] + dc[i];
                if (ddr >= 0 && ddr < n && ddc >= 0 && ddc < m){
                    if (map[ddr][ddc] == 0){
                        cnt++;
                    }
                }
            }
            if (map[cur[0]][cur[1]] - cnt == 0){
                map[cur[0]][cur[1]] = -1;
            } else {
                map[cur[0]][cur[1]] -= cnt;
            }
        }
    }
    public static void dfsAll(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (map[i][j] > 0 && !visited[i][j]){
                    groupCnt++;
                    dfs(i, j);
                }
            }
        }
    }
    public static void dfs(int r, int c){

        visited[r][c] = true;

        for (int i = 0; i < 4; i++){
            int ddr = r + dr[i];
            int ddc = c + dc[i];
            if (ddr >= 0 && ddr < n && ddc >= 0 && ddc < m){
                if (map[ddr][ddc] > 0 && !visited[ddr][ddc]){
                    dfs(ddr, ddc);
                }
            }
        }
    }
}
