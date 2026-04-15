package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1284 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++){
            st = new StringTokenizer(br.readLine());
            int p, q, r, s, w;
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            int costA = p * w;
            int costB;

            if (w <= r){
                costB = q;
            } else {
                costB = q + ((w - r) * s);
            }

            System.out.println("#" + i + " " + Math.min(costA, costB));
        }
    }
}
