package CodePlus500;

import java.io.*;
import java.util.*;

public class BOJ3085 {
    static char[][] candy;
    static int n;
    static int max = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        candy = new char[n][n];

        for (int i = 0; i < n; i++){
            String s = br.readLine();
            for (int j = 0; j < n; j++){
                candy[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n - 1; j++){
                if(candy[i][j] != candy[i][j + 1]){
                    swapRow(i, j);
                    countRow();
                    countCol();
                    swapRow(i, j);
                }
                if (candy[j][i] != candy[j + 1][i]){
                    swapCol(j, i);
                    countRow();
                    countCol();
                    swapCol(j, i);
                }
            }
        }
        System.out.println(max);
    }
    static private void countRow(){
        for (int i = 0; i < n ; i++){
            int cnt = 1;
            for (int j = 0; j < n - 1; j++){
                if (candy[i][j] == candy[i][j + 1]){
                    cnt++;
                }
                if (cnt > max){
                    max = cnt;
                }
                if (candy[i][j] != candy[i][j + 1]){
                    cnt = 1;
                }
            }
        }
    }

    static private void countCol(){
        for (int i = 0; i < n ; i++){
            int cnt = 1;
            for (int j = 0; j < n - 1; j++){
                if (candy[j][i] == candy[j + 1][i]){
                    cnt++;
                }
                if (cnt > max){
                    max = cnt;
                }
                if (candy[j][i] != candy[j + 1][i]){
                    cnt = 1;
                }
            }
        }
    }

    static private void swapRow(int i, int j){
        char tmp = candy[i][j];
        candy[i][j] = candy[i][j + 1];
        candy[i][j + 1] = tmp;
    }

    static private void swapCol(int i, int j){
        char tmp = candy[i][j];
        candy[i][j] = candy[i + 1][j];
        candy[i + 1][j] = tmp;
    }
}
