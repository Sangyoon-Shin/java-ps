package SWEA.D4;

import java.io.*;
import java.util.*;

public class SWEA1226 {
    static int t;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = new int[] {-1, 1, 0, 0};
    static int[] dc = new int[] {0, 0, -1, 1};
    static int startR, startC, destR, destC;
    static boolean isPossible;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++){
            t = Integer.parseInt(br.readLine());
            map = new int[16][16];
            visited = new boolean[16][16];
            startR = 0; startC = 0; destR = 0; destC = 0;
            isPossible = false;

            for (int i = 0; i < 16; i++){
                String s = br.readLine();
                for (int j = 0; j < 16; j++){
                    map[i][j] = s.charAt(j) - '0';
                    if (map[i][j] == 2){
                        startR = i;
                        startC = j;
                    } else if (map[i][j] == 3){
                        destR = i;
                        destC = j;
                    }
                }
            }
            bfs(startR, startC);
            if (isPossible){
                System.out.println("#" + tc + " " + 1);
            } else {
                System.out.println("#" + tc + " " + 0);
            }
        }
    }
    public static void bfs(int r, int c){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[] {r, c});
        visited[r][c] = true;

        while (!q.isEmpty()){
            int[] cur = q.removeFirst();
            for (int i = 0; i < 4; i++){
                int ddr = cur[0] + dr[i];
                int ddc = cur[1] + dc[i];
                if (ddr >= 0 && ddr < 16 && ddc >= 0 && ddc < 16){
                    if (map[ddr][ddc] == 0 && !visited[ddr][ddc]){
                        q.addLast(new int[] {ddr, ddc});
                        visited[ddr][ddc] = true;
                    }
                    if (map[ddr][ddc] == 3){
                        isPossible = true;
                        return;
                    }
                }
            }
        }
    }
}
