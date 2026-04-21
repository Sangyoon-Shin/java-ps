package Implementation;

import java.io.*;
import java.util.*;

public class BOJ1018 {
    static int n, m;
    static char[][] map;
    static int res;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++){
            String s = br.readLine();
            for (int j = 0; j < m; j++){
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i <= n - 8; i++){
            for (int j = 0; j <= m - 8; j++){
                startWithW(i, j);
                startWithB(i, j);
            }
        }
        System.out.println(res);
    }
    public static void startWithW(int x, int y){
        int cnt = 0;
        for (int i = x; i < x + 8; i++){
            for (int j = y; j < y + 8; j++){
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)){
                    if (map[i][j] != 'W'){
                        cnt++;
                    }
                } else if ((i % 2 == 0 && j % 2 == 1) || (i % 2 == 1 && j % 2 == 0)){
                    if (map[i][j] != 'B'){
                        cnt++;
                    }
                }
            }
        }
        res = Math.min(res, cnt);
    }
    public static void startWithB(int x, int y){
        int cnt = 0;
        for (int i = x; i < x + 8; i++){
            for (int j = y; j < y + 8; j++){
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)){
                    if (map[i][j] != 'B'){
                        cnt++;
                    }
                } else if ((i % 2 == 0 && j % 2 == 1) || (i % 2 == 1 && j % 2 == 0)){
                    if (map[i][j] != 'W'){
                        cnt++;
                    }
                }
            }
        }
        res = Math.min(res, cnt);
    }
}
