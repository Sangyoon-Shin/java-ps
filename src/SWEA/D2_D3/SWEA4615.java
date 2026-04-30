package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA4615{
    static int t, n, m;
    static int[][] map;
    static int r, c, color;
    static int cntB, cntW;

    // 상 하 좌 우 좌상 우상 좌하 우하
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            cntB = 0; cntW = 0;

            map[n / 2 - 1][n / 2 - 1] = 2; map[n / 2][n / 2] = 2;
            map[n / 2 - 1][n / 2] = 1; map[n / 2][n / 2 - 1] = 1;

            for (int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                r = Integer.parseInt(st.nextToken()) - 1;
                c = Integer.parseInt(st.nextToken()) - 1;
                color = Integer.parseInt(st.nextToken());
                if (map[r][c] == 0){
                    placeNewStone(r, c, color);
                }
            }
            count();
            System.out.println("#" + tc + " " + cntB + " " + cntW);
        }
    }
    public static void placeNewStone(int r, int c, int color){

        map[r][c] = color; // 둘 수 있는 위치만 나오니까 일단 빈 공간이면 자기 두기

        int diff = 0;
        if (color == 1){
            diff = 2;
        } else {
            diff = 1;
        }

        for (int i = 0; i < 8; i++){
            int ddr = r + dr[i];
            int ddc = c + dc[i];

            boolean findSameColor = false;
            ArrayDeque<int[]> q = new ArrayDeque<>();

            while (ddr >= 0 && ddr < n && ddc >= 0 && ddc < n){
                if (map[ddr][ddc] == 0){
                    break;
                } else if (map[ddr][ddc] == diff){
                    q.add(new int[] {ddr, ddc});
                } else if (map[ddr][ddc] == color){
                    findSameColor = true;
                    break;
                }
                ddr += dr[i];
                ddc += dc[i];
            }

            if (findSameColor){
                while (!q.isEmpty()){
                    int[] replaceInfo = q.removeFirst();
                    int curR = replaceInfo[0];
                    int curC = replaceInfo[1];
                    map[curR][curC] = color;
                }
            }
        }
    }
    public static void count(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (map[i][j] == 1){
                    cntB++;
                } else if (map[i][j] == 2){
                    cntW++;
                }
            }
        }
    }
}