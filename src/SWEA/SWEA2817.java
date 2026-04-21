package SWEA;

import java.io.*;
import java.util.*;

public class SWEA2817 {
    static int[] num;
    static int n, k;
    static int cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            cnt = 0;

            num = new int[n];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++){
                num[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n; i++){
                dfs(i, num[i]);
            }

            System.out.println("#" + tc + " " + cnt);
        }
    }
    public static void dfs(int start, int sum){
        if (sum == k){
            cnt++;
            return;
        }
        if (sum > k){
            return;
        }
        for (int i = start + 1; i < n; i++){
            dfs(i, sum + num[i]);
        }
    }
}
