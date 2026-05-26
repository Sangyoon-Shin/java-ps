package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA11315 {
    static int t, n;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
    static boolean isPossible;
    static int len;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            n = Integer.parseInt(br.readLine());
            map = new char[n][n];
            isPossible = false;
            len = 0;

            for (int i = 0; i < n; i++){
                String s = br.readLine();
                for (int j = 0; j < n; j++){
                    map[i][j] = s.charAt(j);
                }
            }

            loop:
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (map[i][j] == 'o') {
                        len++;
                        dfs(i, j);
                        if (isPossible){
                            System.out.println("#" + tc + " YES");
                            break loop;
                        }
                    }
                }
            }
            if (!isPossible){
                System.out.println("#" + tc + " NO");
            }
        }
    }
    public static void dfs(int r, int c){

        for (int i = 0; i < 8; i++){
            len = 1;
            int ddr = r + dr[i];
            int ddc = c + dc[i];
            while (ddr >= 0 && ddr < n && ddc >= 0 && ddc < n){
                if (map[ddr][ddc] == 'o'){
                    len++;
                    ddr += dr[i];
                    ddc += dc[i];
                } else {
                    break;
                }
                if (len == 5){
                    isPossible = true;
                    return;
                }
            }
        }
    }
}
