package SWEA.D2_D3;

import java.io.*;

public class SWEA1215 {
    static int n;
    static char[][] map;
    static int cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++){
            n = Integer.parseInt(br.readLine());
            map = new char[8][8];
            cnt = 0;

            for (int i = 0; i < 8; i++){
                String s = br.readLine();
                for (int j = 0; j < 8; j++){
                    map[i][j] = s.charAt(j);
                }
            }

            for (int i = 0; i < 8; i++){
                for (int j = 0; j < 8; j++){
                    if (i <= 8 - n){
                        checkCol(i, j);
                    }
                    if (j <= 8 - n){
                        checkRow(i, j);
                    }
                }
            }
            System.out.println("#" + tc + " " + cnt);
        }
    }
    public static void checkCol(int x, int y){

        StringBuilder sb = new StringBuilder();
        for (int i = x; i < x + n; i++){
            sb.append(map[i][y]);
        }
        String cur = sb.toString();
        String revCur = sb.reverse().toString();

        if (cur.equals(revCur)){
            cnt++;
        }
    }
    public static void checkRow(int x, int y){

        StringBuilder sb = new StringBuilder();
        for (int i = y; i < y + n; i++){
            sb.append(map[x][i]);
        }
        String cur = sb.toString();
        String revCur = sb.reverse().toString();

        if (cur.equals(revCur)){
            cnt++;
        }
    }
}
