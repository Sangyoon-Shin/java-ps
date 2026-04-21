package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1216 {
    static char[][] map;
    static int maximum;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++){
            map = new char[100][100];
            maximum = 1;

            int t = Integer.parseInt(br.readLine());
            for (int i = 0; i < 100; i++){
                String s = br.readLine();
                for (int j = 0; j < 100; j++){
                    map[i][j] = s.charAt(j);
                }
            }

            loop:
            for (int len = 100; len >= 1; len--){
                for (int i = 0; i < 100; i++){
                    for (int start = 0; start + len <= 100; start++){
                        if (isPalindromeRow(i, start, len) || isPalindromeCol(i, start, len)){
                            maximum = len;
                            break loop;
                        }
                    }
                }
            }

            System.out.println("#" + t + " " + maximum);
        }
    }
    public static boolean isPalindromeRow(int i, int start, int len){
        int left = start;
        int right = start + len - 1;

        while (left < right){
            if (map[i][left] != map[i][right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static boolean isPalindromeCol(int i, int start, int len){
        int top = start;
        int bottom = start + len - 1;

        while (top < bottom){
            if (map[top][i] != map[bottom][i]){
                return false;
            }
            top++;
            bottom--;
        }
        return true;
    }
}
