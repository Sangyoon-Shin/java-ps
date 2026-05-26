package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA5789 {
    static int t, n, q, l, r;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());

            arr = new int[n + 1];

            for (int i = 1; i <= q; i++){
                st = new StringTokenizer(br.readLine());
                l = Integer.parseInt(st.nextToken());
                r = Integer.parseInt(st.nextToken());

                for (int j = l; j <= r; j++){
                    arr[j] = i;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");

            for (int i = 1; i <= n; i++){
                sb.append(arr[i]).append(" ");
            }
            System.out.println(sb);
        }
    }
}
