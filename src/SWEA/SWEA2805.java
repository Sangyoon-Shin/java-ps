package SWEA;

import java.io.*;
import java.util.*;

public class SWEA2805 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++){
            int n = Integer.parseInt(br.readLine());
            int[][] farm = new int[n][n];

            for (int i = 0; i < n; i++){
                String s = br.readLine();
                for (int j = 0; j < n; j++){
                    farm[i][j] = s.charAt(j) - '0';
                }
            }

            int sum = 0;

            for (int i = 0; i < n; i++){
                sum += farm[n / 2][i];
            }

            for (int i = 1; i <= n / 2; i++){
                for (int j = i; j < n - i; j++){
                    sum += farm[n / 2 - i][j];
                    sum += farm[n / 2 + i][j];
                }
            }
            System.out.println("#" + tc + " " + sum);
        }
    }
}
