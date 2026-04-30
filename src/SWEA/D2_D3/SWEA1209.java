package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA1209 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++){
            int t = Integer.parseInt(br.readLine());
            int[][] matrix = new int[100][100];

            for (int i = 0; i < 100; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++){
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int res = 0;
            for (int i = 0; i < 100; i++){
                int sum = 0;
                for (int j = 0; j < 100; j++){
                    sum += matrix[i][j];
                }
                res = Math.max(res, sum);
            }

            for (int i = 0; i < 100; i++){
                int sum = 0;
                for (int j = 0; j < 100; j++){
                    sum += matrix[j][i];
                }
                res = Math.max(res, sum);
            }

            int sum = 0;
            for (int i = 0; i < 100; i++){
                sum += matrix[i][i];
            }
            res = Math.max(res, sum);

            sum = 0;
            for (int i = 0; i < 100; i++){
                sum += matrix[i][100 - (i + 1)];
            }
            res = Math.max(res, sum);

            System.out.println("#" + tc + " " + res);
        }
    }
}
