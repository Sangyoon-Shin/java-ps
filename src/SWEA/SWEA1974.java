package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1974 {
    static int[][] matrix = new int[9][9];
    static boolean[] flag;
    static boolean isPossible;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++){
            int res = 1;
            isPossible = true;
            for (int j = 0; j < 9; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 9; k++) {
                    matrix[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            // 3 x 3 탐색해서 일단 거기에 9개 숫자가 다 들어있는지 파악. -> 중복있으면 탈락
            // 다 들어있으면 3 x 3 의 각 좌표들의 행, 열 비교해서 중복있는지 파악. -> 중복있으면 탈락

            for (int j = 0; j < 9; j += 3){
                for (int k = 0; k < 9; k += 3){
                    rec(j, k);
                }
            }

            if (!isPossible){
                res = 0;
                System.out.println("#" + i + " " + res);
            } else {
                for (int j = 0; j < 9; j++){
                    for (int k = 0; k < 9; k++){
                        rcFind(j, k);
                    }
                }
                if (!isPossible){
                    res = 0;
                    System.out.println("#" + i + " " + res);
                } else {
                    System.out.println("#"   + i + " " + res);
                }
            }
        }

    }
    public static void rec(int r, int c){
        flag = new boolean[10];

        for (int i = r; i < r + 3; i++){
            for (int j = c; j < c + 3; j++){
                int cur = matrix[i][j];
                if (!flag[cur]){
                    flag[cur] = true;
                } else {
                    isPossible = false;
                    return;
                }
            }
        }
    }
    public static void rcFind(int r, int c){
        flag = new boolean[10];

        // 행 파악
        for (int i = 0; i < 9; i++){
            int cur = matrix[r][i];
            if (!flag[cur]){
                flag[cur] = true;
            } else {
                isPossible = false;
                return;
            }
        }

        flag = new boolean[10];

        // 열 파악
        for (int i = 0; i < 9; i++){
            int cur = matrix[i][c];
            if (!flag[cur]){
                flag[cur] = true;
            } else {
                isPossible = false;
                return;
            }
        }
    }
}
