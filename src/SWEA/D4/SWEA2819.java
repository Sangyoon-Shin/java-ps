package SWEA.D4;

import java.io.*;
import java.util.*;

public class SWEA2819 {
    static int t;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Set<String> set;
    public static void main(String[] args) throws IOException{
        // 모든 칸에서 4방향으로 갈 수 있다 가정하면 4^7 => 16.000. 이게 총 16칸 => 256,000. 최대 깊이 7 => DFS
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++){
            map = new int[4][4];
            set = new HashSet<>();

            for (int i = 0; i < 4; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < 4; i++){
                for (int j = 0; j < 4; j++){
                    dfs(i, j,"" + map[i][j]);
                }
            }
            System.out.println("#" + tc + " " + set.size());
        }
    }
    public static void dfs(int r, int c, String cur){
        if (cur.length() == 7){
            set.add(cur);
            return;
        }
        for (int i = 0; i < 4; i++){
            int ddr = r + dr[i];
            int ddc = c + dc[i];
            if (ddr >= 0 && ddr < 4 && ddc >= 0 && ddc < 4){
                dfs(ddr, ddc, cur + map[ddr][ddc]);
            }
        }
    }
}
