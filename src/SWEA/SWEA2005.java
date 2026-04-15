package SWEA;

import java.io.*;
import java.util.*;

public class SWEA2005 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] pascal = new int[10][10];
        pascal[0][0] = 1;
        pascal[1][0] = 1;
        pascal[1][1] = 1;

        for (int i = 2; i < 10; i++){
            pascal[i][0] = pascal[i - 1][0];
            pascal[i][i] = pascal[i - 1][i - 1];
            for (int j = 1; j <= i - 1; j++){
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }


        int t = Integer.parseInt(br.readLine());



        for (int i = 1; i <= t; i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println("#" + i);
            for (int j = 0; j < n; j++){
                for (int k = 0; k <= j; k++){
                    System.out.print(pascal[j][k] + " ");
                }
                System.out.println();
            }
        }
    }
}
