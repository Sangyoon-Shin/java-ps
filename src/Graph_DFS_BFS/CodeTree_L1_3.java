package Graph_DFS_BFS;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class CodeTree_L1_3 {
    static int n, cnt, res;
    static int[][] map;
    static int[] dr = new int[] {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = new int[] {0, 0, -1, 1, -1, 1, -1, 1};
    static ArrayList<int[]> dir = new ArrayList<>(); // 폭탄 좌표
    static ArrayList<Integer> order = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        cnt = 0; res = 0;

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1){
                    dir.add(new int[] {i, j});
                    cnt++;
                }
            }
        }

        // 폭탄이 놓여져 있는 개수에 들어갈 수 있는 3개 폭탄의 순열. (1, 3), (3, 1)은 다름.
        dfs(0);
        System.out.println(res);

    }
    public static void dfs(int depth){
        if (depth == cnt){
            doBomb();
            return;
        }
        for (int i = 1; i <= 3; i++){
            order.add(i);
            dfs(depth + 1);
            order.remove(order.size() - 1);
        }
    }
    public static void doBomb(){
        // order에 담겨있는 순서대로 폭탄이 들어갈 좌표에 폭탄 번호를 부여하고, 터뜨려보기. 그때 터진 범위가 가장 큰 값이 결과
        for (int i = 0; i < dir.size(); i++){
            int[] val = dir.get(i);
            int r = val[0];
            int c = val[1];
            map[r][c] = order.get(i);
        }

        for (int[] val : dir){
            int r = val[0];
            int c = val[1];
            if (map[r][c] == 1){ // 1. 위 아래로 두 칸씩
                for (int i = -2; i < 3; i++){
                    int dr = r + i;
                    if (dr >= 0 && dr < n && i != 0 && map[dr][c] == 0){
                        map[dr][c] = 9;
                    }
                }
            } else if (map[r][c] == 2){ // 2. 상하좌우 날리는 폭탄
                for (int i = 0; i < 4; i++){
                    int ddr = r + dr[i];
                    int ddc = c + dc[i];
                    if (ddr >= 0 && ddr < n && ddc >= 0 && ddc < n){
                        if (map[ddr][ddc] == 0){
                            map[ddr][ddc] = 9;
                        }
                    }
                }
            } else if (map[r][c] == 3){ // 3. 대각선 날리는 폭탄
                for (int i = 4; i < 8; i++){
                    int ddr = r + dr[i];
                    int ddc = c + dc[i];
                    if (ddr >= 0 && ddr < n && ddc >= 0 && ddc < n){
                        if (map[ddr][ddc] == 0){
                            map[ddr][ddc] = 9;
                        }
                    }
                }
            }
        }

        // 폭탄의 영향에 의해 터진부위 개수 세기
        int count = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (map[i][j] == 9){
                    count++;
                }
            }
        }
        count += cnt;
        res = Math.max(res, count);

        // 폭탄이었던 부분 제외하고는 다시 0으로 바궈서 터뜨리기 이전으로 돌려놔야함.
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (map[i][j] == 9){
                    map[i][j] = 0;
                }
            }
        }
    }
}
