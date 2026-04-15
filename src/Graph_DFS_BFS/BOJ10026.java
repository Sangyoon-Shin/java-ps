package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ10026 {
    static String[] map;
    static char[][] newmap;
    static boolean[][] visited;
    static int n;
    static int cnt;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new String[n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++){
            map[i] = br.readLine();
        }

        cnt = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                char color;
                if (map[i].charAt(j) == 'R' && !visited[i][j]){
                    cnt++;
                    color = 'R';
                    dfsOne(i, j, color);
                } else if (map[i].charAt(j) == 'G' && !visited[i][j]){
                    cnt++;
                    color = 'G';
                    dfsOne(i, j, color);
                } else if (map[i].charAt(j) == 'B' && !visited[i][j]) { // 여기 else로 쓰면 틀렸음.
                    cnt++;
                    color = 'B';
                    dfsOne(i, j, color);
                }
            }
        }
        System.out.print(cnt + " ");

        cnt = 0;
        visited = new boolean[n][n];
        newmap = new char[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (map[i].charAt(j) == 'R' || map[i].charAt(j) == 'G'){
                    newmap[i][j] = 'X';
                } else {
                    newmap[i][j] = 'B';
                }
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                char color;
                if (newmap[i][j] == 'X' && !visited[i][j]){
                    color = 'X';
                    cnt++;
                    dfsTwo(i, j, color);
                } else if(newmap[i][j] == 'B' && !visited[i][j]){
                    color = 'B';
                    cnt++;
                    dfsTwo(i, j, color);
                }
            }
        }
        System.out.println(cnt);


    }
    private static void dfsOne(int r, int c, char color){
        visited[r][c] = true;
        for (int i = 0; i < 4; i++){
            int ddr = r + dr[i];
            int ddc = c + dc[i];
            if (ddr >= 0 && ddr < n && ddc >= 0 && ddc < n){
                if (map[ddr].charAt(ddc) == color && !visited[ddr][ddc]){
                    dfsOne(ddr, ddc, color);
                }
            }
        }
    }
    private static void dfsTwo(int r, int c, char color){
        visited[r][c] = true;
        for (int i = 0; i < 4; i++){
            int ddr = r + dr[i];
            int ddc = c + dc[i];
            if (ddr >= 0 && ddr < n && ddc >= 0 && ddc < n){
                if (newmap[ddr][ddc] == color && !visited[ddr][ddc]){
                    dfsTwo(ddr, ddc, color);
                }
            }
        }
    }
}
