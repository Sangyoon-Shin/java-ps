package SWEA.D4;

import java.io.*;
import java.util.*;

public class SWEA1486 {
    static int t, n, b, min;
    static int[] height;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;

            height = new int[n];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++){
                height[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);

            System.out.println("#" + tc + " " + (min - b));
        }
    }
    public static void dfs(int start, int h){
        if (h >= b){
            if (h < min){
                min = h;
            }
            return;
        }
        if (start < n){
            dfs(start + 1, h + height[start]);
            dfs(start + 1, h);
        }

    }
}
