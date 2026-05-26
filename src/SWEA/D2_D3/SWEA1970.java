package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA1970 {
    static int t, money;
    static int[] change = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10};
    static int[] coin;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++){
            money = Integer.parseInt(br.readLine());

            if (money % 10 != 0){
                money -= (money % 10);
            }

            coin = new int[8];

            while (money > 0){
                for (int i = 0; i < 8; i++){
                    if (money >= change[i]){
                        coin[i] += money / change[i];
                        money -= (change[i] * coin[i]);
                        break;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append('\n');
            for (int i = 0; i < 8; i++){
                sb.append(coin[i]).append(' ');
            }
            System.out.println(sb);
        }

    }
}
