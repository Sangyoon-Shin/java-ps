package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1210 {
    // 위, 좌, 우 방향으로만 이동가능.
    static int[] dr = {0, 0, -1};
    static int[] dc = {-1, 1, 0};
    static ArrayDeque<int[]> q;
    static int[][] map;
    static int resC;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++){
            int t = Integer.parseInt(br.readLine());

            q = new ArrayDeque<>();
            map = new int[100][100];
            visited = new boolean[100][100];
            resC = 0;

            for (int i = 0; i < 100; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++){
                    int cur = Integer.parseInt(st.nextToken());
                    if (cur == 2){
                        q.addLast(new int[] {i, j});
                        visited[i][j] = true;
                    }
                    map[i][j] = cur;
                }
            }

            bfs();
            System.out.println("#" + tc + " " + resC);

        }
    }
    public static void bfs(){

        boolean find = false;
        int res = 0;
        while (!q.isEmpty()){
            int[] cur = q.removeFirst(); // 얘는 좌표다.
            boolean goRightOrLeft = false;

            for (int i = 0; i < 2; i++){
                // 좌, 우, 위 보면서 일단, 좌/우로 갈 수 있으면 거기가 우선, 좌/우 없으면 위로
                int ddr = cur[0] + dr[i];
                int ddc = cur[1] + dc[i];

                if (ddr >= 0 && ddr < 100 && ddc >= 0 && ddc < 100){
                    if (map[ddr][ddc] == 1 && !visited[ddr][ddc]){ // 좌, 우가 1이면 무조건 거기로 이동.
                        q.addLast(new int[] {ddr, ddc});
                        visited[ddr][ddc] = true;
                        goRightOrLeft = true;
                        break;
                    }
                }
            }
            if (!goRightOrLeft){ // 좌/우로 갈 수 없는 상황이었으면 무조건 위로 가야함.
                int ddr = cur[0] + dr[2];
                int ddc = cur[1] + dc[2];
                if (ddr >= 0 && ddr < 100 && ddc >= 0 && ddc < 100){
                    if (!visited[ddr][ddc]){
                        if (ddr == 0) {
                            resC = ddc;
                        } else {
                            q.addLast(new int[] {ddr, ddc});
                            visited[ddr][ddc] = true;
                        }
                    }
                }
            }
        }
    }
}
