import java.io.*;
import java.util.*;

public class Main{
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int n;
    static int cnt;
    static ArrayList<Integer> res;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        cnt = 0;
        res = new ArrayList<>();

        for (int i = 0; i < n; i++){
            String s = br.readLine();
            for (int j = 0; j < n; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (map[i][j] == 1 && !visited[i][j]){
                    cnt = 0;
                    dfs(i, j);
                    res.add(cnt);
                }
            }
        }
        Collections.sort(res);
        System.out.println(res.size());
        for (int i = 0; i < res.size(); i++){
            System.out.println(res.get(i));
        }
    }
    static private void dfs(int r, int c){
        visited[r][c] = true;
        cnt++;

        for (int i = 0; i < 4; i++){
            int ddr = r + dr[i];
            int ddc = c + dc[i];
            if (ddr >= 0 && ddr < n && ddc >= 0 && ddc < n){
                if (map[ddr][ddc] == 1 && !visited[ddr][ddc]){
                    dfs(ddr, ddc);
                } else {
                    continue;
                }
            }
        }
    }

}