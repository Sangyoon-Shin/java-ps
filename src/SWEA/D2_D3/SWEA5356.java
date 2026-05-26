package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA5356 {
    static int t;
    static String str;
    static char[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            map = new char[5][15];
            for (int i = 0; i < 5; i++){
                str = br.readLine();
                for (int j = 0; j < str.length(); j++){
                    map[i][j] = str.charAt(j);
                }
                for (int j = str.length(); j < 15; j++){
                    map[i][j] = ' ';
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 15; i++){
                for (int j = 0; j < 5;j++){
                    if (map[j][i] == ' '){
                        continue;
                    } else {
                        sb.append(map[j][i]);
                    }
                }
            }
            System.out.println("#" + tc + " " + sb);
        }
    }
}
