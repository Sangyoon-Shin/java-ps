package SWEA.D4;

import java.io.*;
import java.util.*;

public class SWEA1868 {
    static int n, t;
    static int[][] map;
    static boolean[][] visited;
    static ArrayDeque<int[]> q;
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
    static int count, restCount;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++){
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visited = new boolean[n][n];
            q = new ArrayDeque<>();
            count = 0; restCount = 0;

            for (int i = 0; i < n; i++){
                String s = br.readLine();
                for (int j = 0; j < n; j++){
                    if (s.charAt(j) == '*'){
                        map[i][j] = -1;
                    } else {
                        map[i][j] = 0;
                    }
                }
            }
            checkZero();

            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (map[i][j] == 0 && !visited[i][j]){
                        count++;
                        bfs(i, j);
                    }
                }
            }
            countRest();

            System.out.println("#" + tc + " " + (count + restCount));
        }
    }
    public static void checkZero(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (map[i][j] == 0){
                    int cnt = checkAround(i, j);
                    map[i][j] = cnt;
                }
            }
        }
    }
    public static int checkAround(int r, int c){
        int cnt = 0;
        for (int i = 0; i < 8; i++){
            int ddr = r + dr[i];
            int ddc = c + dc[i];
            if (ddr >= 0 && ddr < n && ddc >= 0 && ddc < n){
                if (map[ddr][ddc] == -1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void bfs(int r, int c){
        visited[r][c] = true;
        q.addLast(new int[] {r, c});

        while (!q.isEmpty()){
            int[] cur = q.removeFirst();
            for (int i = 0; i < 8; i++){
                int ddr = cur[0] + dr[i];
                int ddc = cur[1] + dc[i];
                if (ddr >= 0 && ddr < n && ddc >= 0 && ddc < n){
                    if (!visited[ddr][ddc] && map[ddr][ddc] == 0){
                        visited[ddr][ddc] = true;
                        q.addLast(new int[] {ddr, ddc});
                    }
                    if (!visited[ddr][ddc] && map[ddr][ddc] > 0){
                        visited[ddr][ddc] = true;
                    }
                }
            }
        }
    }
    public static void countRest(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (map[i][j] > 0 && !visited[i][j]){
                    restCount++;
                }
            }
        }
    }
}
