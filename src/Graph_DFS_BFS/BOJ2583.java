package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ2583 {
    static int[][] map;
    static boolean[][] visited;
    static int cnt = 0;
    static int area = 0;
    static int n, m, k;
    static int lbx, lby, rtx, rty;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static ArrayList<Integer> count = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            lbx = Integer.parseInt(st.nextToken());
            lby = Integer.parseInt(st.nextToken());
            rtx = Integer.parseInt(st.nextToken());
            rty = Integer.parseInt(st.nextToken());
            for (int y = lby; y < rty; y++){
                for (int x = lbx; x < rtx; x++){
                    map[y][x] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (map[i][j] == 0 && !visited[i][j]){
                    area++;
                    bfs(i, j);
                    count.add(cnt);
                    cnt = 0;
                }
            }
        }
        System.out.println(area);
        Collections.sort(count);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.size(); i++){
            sb.append(count.get(i)).append(' ');
        }
        System.out.print(sb);

    }
    static private void bfs(int r, int c){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[r][c] = true;
        q.addLast(new int[] {r, c});
        cnt++;

        while (!q.isEmpty()){
            int cur[] = q.removeFirst();
            for (int i = 0; i < 4; i++){
                int ddr = cur[0] + dr[i];
                int ddc = cur[1] + dc[i];
                if (ddr >= 0 && ddr < m && ddc >= 0 && ddc < n){
                    if (map[ddr][ddc] == 0 && !visited[ddr][ddc]){
                        visited[ddr][ddc] = true;
                        q.addLast(new int[] {ddr, ddc});
                        cnt++;
                    }
                }
            }
        }
    }
}
