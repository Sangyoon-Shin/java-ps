package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA1860 {
    static int t, n, m, k;
    static int[] bread;
    static int[] wait;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            wait = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++){
                wait[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(wait);

            int maxSize = wait[n - 1];
            bread = new int[maxSize + 1];

            int prev = 0;
            int ptr = 0;
            boolean isPossible = true;
            for (int i = 0; i <= maxSize; i++){
                if (i % m == 0 && i != 0){
                    bread[i] += prev + k;
                    prev = bread[i];
                } else {
                    bread[i] = prev;
                }
                if (wait[ptr] == i){
                    while (wait[ptr] == i){
                        bread[i] -= 1;
                        prev -= 1;
                        if (bread[i] < 0){
                            isPossible = false;
                            break;
                        }
                        ptr++;
                        if (ptr == n){
                            break;
                        }
                    }
                }
            }

            if (isPossible){
                System.out.println("#" + tc + " Possible");
            } else {
                System.out.println("#" + tc + " Impossible");
            }
        }
    }
}
