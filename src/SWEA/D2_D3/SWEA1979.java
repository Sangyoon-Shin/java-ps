package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA1979 {
    static int[][] matrix;
    static int[][] rmatrix;
    static int[][] cmatrix;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            matrix = new int[n][n];
            rmatrix = new int[n][n];
            cmatrix = new int[n][n];

            for (int r = 0; r < n; r++){
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < n; c++){
                    matrix[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            // 일단 각 행에 대해 보면서 가로길이 3인 개수 찾기
            for (int r = 0; r < n; r++){
                int len;
                if (matrix[r][0] == 0){
                    len = 0;
                } else {
                    len = 1;
                }
                for (int c = 1; c < n; c++){
                    if (matrix[r][c] == 1){
                        if (len > 0){
                            len++;
                        }
                    } else {
                        len = 0;
                    }
                }
            }
        }



    }
}
