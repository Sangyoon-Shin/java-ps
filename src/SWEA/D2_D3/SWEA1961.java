package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA1961 {
    static int t, n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            n = Integer.parseInt(br.readLine());
            String[][] map = new String[n][n];

            for (int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++){
                    map[i][j] = st.nextToken();
                }
            }

            String[][] res = new String[n][3];
            for (int i = 0; i < n; i++){
                String cur = "";
                for (int j = n - 1; j >= 0; j--){
                    cur += map[j][i];
                }
                res[i][0] = cur;
            }

            for (int i = n - 1; i >= 0; i--){
                String cur = "";
                for (int j = n - 1; j >= 0; j--){
                    cur += map[i][j];
                }
                res[n - i - 1][1] = cur;
            }

            for (int i = n - 1; i >= 0; i--){
                String cur = "";
                for (int j = 0; j < n; j++){
                    cur += map[j][i];
                }
                res[n - i - 1][2] = cur;
            }

            System.out.println("#" + tc);
            for (int i = 0; i < n; i++){
                for (int j = 0; j < 3; j++){
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }
        }


    }
}
