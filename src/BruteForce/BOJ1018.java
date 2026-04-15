package BruteForce;

import java.util.*;
import java.io.*;

public class BOJ1018 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];

        for (int i = 0; i < n; i++){
            String cur = br.readLine();
            for (int j = 0; j < cur.length(); j++){
                board[i][j] = cur.charAt(j);
            }
        }

        char[][] startWithW = new char[n][m];
        char[][] startWithB = new char[n][m];
        startWithW = changeToWStart(startWithW);
        startWithB = changeToBStart(startWithB);

        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                System.out.print(startWithW[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                System.out.print(startWithB[i][j] + " ");
            }
            System.out.println();
        }

    }
    public static char[][] changeToWStart(char[][] b){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (i % 2 == 0){
                    if (j % 2 == 0){
                        b[i][j] = 'W';
                    } else {
                        b[i][j] = 'B';
                    }
                } else {
                    if (j % 2 == 0){
                        b[i][j] = 'B';
                    } else {
                        b[i][j] = 'W';
                    }
                }
            }
        }
        return b;
    }

    public static char[][] changeToBStart(char[][] b){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (i % 2 == 0){
                    if (j % 2 == 0){
                        b[i][j] = 'B';
                    } else {
                        b[i][j] = 'W';
                    }
                } else {
                    if (j % 2 == 0){
                        b[i][j] = 'W';
                    } else {
                        b[i][j] = 'B';
                    }
                }
            }
        }
        return b;
    }
}
