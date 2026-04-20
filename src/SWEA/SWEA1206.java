package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1206 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++){
            int n = Integer.parseInt(br.readLine());
            int[] h = new int[n];

            st = new StringTokenizer(br.readLine());

            int res = 0;
            for (int i = 0; i < n; i++){
                h[i] = Integer.parseInt(st.nextToken());
            }

            for (int j = 2; j < n - 2; j++){
                int cur = h[j];
                int l1 = h[j - 1];
                int l2 = h[j - 2];
                int r1 = h[j + 1];
                int r2 = h[j + 2];
                int lmax = Math.max(l1, l2);
                int rmax = Math.max(r1, r2);
                if (lmax < cur && rmax < cur){
                    res += (cur - Math.max(lmax, rmax));
                }
            }

            System.out.println("#" + tc + " " + res);
        }
    }
}
