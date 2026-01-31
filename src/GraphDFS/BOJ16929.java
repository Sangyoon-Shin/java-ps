package GraphDFS;

import java.io.*;
import java.util.*;

public class BOJ16929 {

    static char[][] map;
    static boolean[][] visited;
    static boolean isCycle = false;
    static char color;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static int n, m;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++){
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++){
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (!isCycle){
                    if (!visited[i][j]){
                        color = map[i][j];
                        dfs(i, j, -1, -1, color);
                    }
                } else {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        if (!isCycle){
            System.out.println("No");
        }
    }
    private static void dfs(int r, int c, int prevr, int prevc, char color){
        if (isCycle){
            return;
        }
        visited[r][c] = true;
        for (int i = 0; i < 4; i++){
            int goR = r + dr[i];
            int goC = c + dc[i];
            if (goR >= 0 && goR < n && goC >= 0 && goC < m){
                // 상하좌우 후보에서 이전 노드 X, 같은 색이면 이동 가능
                if (map[goR][goC] == color){
                    if (!visited[goR][goC]){
                        dfs(goR, goC, r, c, color);
                    } else {
                        // 방문했던 곳인데, 얘가 이전 노드가 아니면 싸이클 형성하고 온거니까
                        if (!(goR == prevr && goC == prevc)){
                            isCycle = true;
                            return;
                        }
                    }
                }
            }
        }
    }
}
