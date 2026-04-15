package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ5427 {
    static int t, w, h;
    static int[][] fireMap;
    static int[][] humanMap;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static ArrayDeque<int[]> fireq;
    static ArrayDeque<int[]> humanq;
    static int[] humanPos;
    static boolean isPossible;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++){
            String[] cur = br.readLine().split(" ");
            w = Integer.parseInt(cur[0]);
            h = Integer.parseInt(cur[1]);

            fireMap = new int[h][w];
            humanMap = new int[h][w];
            visited = new boolean[h][w];
            fireq = new ArrayDeque<>();
            humanq = new ArrayDeque<>();
            isPossible = false;

            for (int r = 0; r < h; r++){
                String s = br.readLine();
                for (int c = 0; c < w; c++){
                    if (s.charAt(c) == '#'){
                        fireMap[r][c] = -1;
                        humanMap[r][c] = -1;
                    } else if (s.charAt(c) == '*'){
                        fireMap[r][c] = 0;
                        humanMap[r][c] = -1;
                        fireq.addLast(new int[] {r, c});
                        visited[r][c] = true;
                    } else if (s.charAt(c) == '@'){
                        fireMap[r][c] = 0;
                        humanMap[r][c] = 0;
                        humanPos = new int[] {r, c};
                        humanq.addLast(humanPos);
                    } else {
                        humanMap[r][c] = 0;
                        fireMap[r][c] = -2;
                    }
                }
            }

            bfsFire();
            visited = new boolean[h][w];
            visited[humanPos[0]][humanPos[1]] = true;
            bfsHuman();

            if (!isPossible){
                System.out.println("IMPOSSIBLE");
            }
        }
    }
    public static void bfsFire(){

        while (!fireq.isEmpty()){
            int[] cur = fireq.removeFirst();
            for (int i = 0; i < 4; i++){
                int ddr = cur[0] + dr[i];
                int ddc = cur[1] + dc[i];
                if (ddr >= 0 && ddr < h && ddc >= 0 && ddc < w){
                    if (fireMap[ddr][ddc] == -2 && !visited[ddr][ddc]){
                        fireMap[ddr][ddc] = fireMap[cur[0]][cur[1]] + 1;
                        visited[ddr][ddc] = true;
                        fireq.addLast(new int[] {ddr, ddc});
                    } else if (fireMap[ddr][ddc] == 0 && !visited[ddr][ddc]){
                        fireMap[ddr][ddc] = fireMap[cur[0]][cur[1]] + 1;
                        visited[ddr][ddc] = true;
                        fireq.addLast(new int[] {ddr, ddc});
                    }
                }
            }
        }
    }

    public static void bfsHuman(){

        while (!humanq.isEmpty()){
            int[] cur = humanq.removeFirst();
            for (int i = 0; i < 4; i++){
                int ddr = cur[0] + dr[i];
                int ddc = cur[1] + dc[i];
                if (ddr < 0 || ddr >= h || ddc < 0 || ddc >= w){
                    isPossible = true;
                    System.out.println(humanMap[cur[0]][cur[1]] + 1);
                    return;
                } else {
                    if (humanMap[ddr][ddc] == 0 && !visited[ddr][ddc]){
                        if (humanMap[cur[0]][cur[1]] + 1 < fireMap[ddr][ddc] || fireMap[ddr][ddc] == -2){
                            humanMap[ddr][ddc] = humanMap[cur[0]][cur[1]] + 1;
                            visited[ddr][ddc] = true;
                            humanq.addLast(new int[] {ddr, ddc});
                        }
                    }
                }
            }
        }

    }
}
