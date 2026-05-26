package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA1979 {
    static int t, n, k;
    static int[][] map;
    static int res;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[n][n];
            res = 0;

            for (int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++){
                int prev = map[i][0];
                int cnt = 0;
                if (prev == 1){
                    cnt = 1;
                }

                for (int j = 1; j < n; j++){
                    if (map[i][j] == 1){
                        if (prev == 1){
                            cnt++;
                        } else {
                            prev = 1;
                            cnt = 1;
                        }
                    }
                    if (map[i][j] == 0 && prev == 1){
                        if (cnt == k){
                            res++;
                        }
                        cnt = 0;
                    }
                }
                if (prev == 1 && cnt == k){
                    res++;
                }
            }

            for (int i = 0; i < n; i++){
                int prev = map[0][i];
                int cnt = 0;
                if (prev == 1){
                    cnt = 1;
                }

                for (int j = 1; j < n; j++){
                    if (map[j][i] == 1){
                        if (prev == 1){
                            cnt++;
                        } else {
                            prev = 1;
                            cnt = 1;
                        }
                    }
                    if (map[j][i] == 0 && prev == 1){
                        if (cnt == k){
                            res++;
                        }
                        cnt = 0;
                    }
                }
                if (prev == 1 && cnt == k){
                    res++;
                }
            }

            System.out.println("#" + tc + " " + res);
        }
    }
}
