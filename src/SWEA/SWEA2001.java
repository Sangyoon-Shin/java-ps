package SWEA;

import java.io.*;
import java.util.*;

public class SWEA2001 {
    static int[][] arr;
    static int n, m;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n][n];

            for (int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            int res = sol();
            System.out.println("#" + i + " " + res);
        }
    }
    public static int sol(){

        int max = 0;
        for (int i = 0; i <= n - m; i++){
            for (int j = 0; j <= n - m; j++){
                int res = cal(i, j);
                if (res > max){
                    max = res;
                }
            }
        }
        return max;
    }
    public static int cal(int r, int c){
        int sum = 0;
        for (int i = r; i < r + m; i++){
            for (int j = c; j < c + m; j++){
                sum += arr[i][j];
            }
        }
        return sum;
    }
}
