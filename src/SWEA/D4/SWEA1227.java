package SWEA.D4;

import java.io.*;
import java.util.*;

public class SWEA1227 {
    static int t;
    static int[][] map;
    static boolean[][] visited;
    static boolean isPossible;
    static ArrayDeque<int[]> q;
    static int[] dr = new int[] {-1, 1, 0, 0};
    static int[] dc = new int[] {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++){
            t = Integer.parseInt(br.readLine());
            map = new int[100][100];
            visited = new boolean[100][100];
            isPossible = false;
            q = new ArrayDeque<>();

            for (int i = 0; i < 100; i++){
                String s = br.readLine();
                for (int j = 0; j < 100; j++){
                    map[i][j] = s.charAt(j) - '0';
                    if (map[i][j] == 2){
                        visited[i][j] = true;
                        q.addLast(new int[] {i, j});
                    }
                }
            }
            bfs();

            if (isPossible){
                System.out.println("#" + tc + " " + 1);
            } else {
                System.out.println("#" + tc + " " + 0);
            }
        }
    }
    public static void bfs(){
        while (!q.isEmpty()){
            int[] cur = q.removeFirst();
            for (int i = 0; i < 4; i++){
                int ddr = cur[0] + dr[i];
                int ddc = cur[1] + dc[i];
                if (ddr >= 0 && ddr < 100 && ddc >= 0 && ddc < 100){
                    if (map[ddr][ddc] == 0 && !visited[ddr][ddc]){
                        visited[ddr][ddc] = true;
                        q.addLast(new int[] {ddr, ddc});
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
