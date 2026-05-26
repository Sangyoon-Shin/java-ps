package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA1948 {
    static int[] maxDay = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());

            int m1 = Integer.parseInt(st.nextToken());
            int d1 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            int d2 = Integer.parseInt(st.nextToken());

            if (m1 == m2){
                sb.append("#").append(tc).append(" ").append(d2 - d1 + 1);
                System.out.println(sb);
            } else {
                int m1Day = maxDay[m1] - d1;
                int m2Day = d2 + 1;

                int total = m1Day + m2Day;
                for (int j = m1 + 1; j < m2; j++){
                    total += maxDay[j];
                }
                sb.append("#").append(tc).append(" ").append(total);
                System.out.println(sb);
            }
        }
    }
}
