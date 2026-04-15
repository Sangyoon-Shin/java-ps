package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ4963 {
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[][] map;
    static boolean[][] visited;
    static int cnt;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // w, h 최대 50이니까 50*50 => 2500. dfs 완탐으로 풀 수 있겠네
        while (true){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0){
                break;
            } else {
                map = new int[h][w];
                visited = new boolean[h][w];
                cnt = 0;

                // map 입력 받고
                for (int i = 0; i < h; i++){
                    st = new StringTokenizer(br.readLine());
                    for (int j = 0; j < w; j++){
                        map[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
                // 모든 노드 탐색하면서 dfs 실시
                for (int i = 0;i < h; i++){
                    for (int j = 0; j < w; j++){
                        if (map[i][j] == 1 && !visited[i][j]){
                            cnt++;
                            dfs(i, j, w, h);
                        }
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    private static void dfs(int r, int c, int width, int height){
        visited[r][c] = true;

        for (int i = 0; i < 8; i++){
            int goR = r + dr[i];
            int goC = c + dc[i];
            if (goR >= 0 && goR < height && goC >= 0 && goC < width){
                if (map[goR][goC] == 1 && !visited[goR][goC]){
                    dfs(goR, goC, width, height);
                }
            }
        }
    }
}
