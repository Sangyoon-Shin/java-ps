package SWEA.D2_D3;

import java.io.*;
import java.util.*;
public class SWEA4825 {
    static int t, n, m;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int prev = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

            for (int i = 0; i < m; i++){
                prev += arr[i];
            }
            max = Math.max(max, prev);
            min = Math.min(min, prev);

            for (int i = 1; i <= n - m; i++){
                prev = prev - arr[i - 1] + arr[i + m - 1];
                max = Math.max(max, prev);
                min = Math.min(min, prev);
            }
            System.out.println("#" + tc + " " + (max - min));
        }
    }
}
