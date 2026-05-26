package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA1976 {
    static int t, h1, m1, h2, m2;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            h1 = Integer.parseInt(st.nextToken());
            m1 = Integer.parseInt(st.nextToken());
            h2 = Integer.parseInt(st.nextToken());
            m2 = Integer.parseInt(st.nextToken());

            int h = 0, m = 0;

            h = h1 + h2;
            m = m1 + m2;

            if (m > 59){
                h += 1;
                m %= 60;
            }
            if (h > 12){
                if (h < 24){
                    h %= 12;
                } else {
                    if (h % 12 == 0){
                        h = 12;
                    } else {
                        h %= 24;
                    }
                }
            }
            System.out.println("#" + tc + " " + h + " " + m);
        }

    }
}
