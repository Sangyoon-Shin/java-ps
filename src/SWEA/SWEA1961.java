package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1961 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++){
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];

            for (int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++){
                    matrix[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            String[][] str = new String[n][n];

            for (int j = 0; j < n; j++){
                for (int k = 0; k < n; k++){

                }
            }
        }

    }
}
