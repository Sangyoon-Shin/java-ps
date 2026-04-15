package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ2667 {
    static int[][] map;
    static boolean[][] visited;
    static int cnt;
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static int n;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        List<Integer> size = new ArrayList<>();

        for (int i = 0; i < n; i++){
            String info = br.readLine();
            for (int j = 0; j < info.length(); j++){
                map[i][j] = info.charAt(j) - '0';
            }
        }

        // 모든 노드 돌면서 dfs 수행
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (map[i][j] == 1 && !visited[i][j]){ // 집이 있고, 방문한 적이 없으면 dfs 실행
                    cnt = 0;
                    dfs(i, j);
                    size.add(cnt);
                }
            }
        }
        Collections.sort(size);
        System.out.println(size.size());
        for (int i = 0; i < size.size(); i++){
            System.out.println(size.get(i));
        }
    }
    private static void dfs(int r, int c){
        visited[r][c] = true;
        cnt ++;

        for (int i = 0; i < 4; i++){
            int dr = r + dx[i];
            int dc = c + dy[i];
            // 상하좌우를 다 돌면서
            // 먼저 dr, dc가 범위 안에 존재하는지. map[dr][dc]가 집이면서 아직 방문한 적 없는지
            if (dr >= 0 && dr < n && dc >= 0 && dc < n){
                if (map[dr][dc] == 1 && !visited[dr][dc]){
                    dfs(dr, dc);
                }
            } else {
                continue;
            }
        }
    }
}
