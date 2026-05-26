package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA6485 {
    static int t, n, p;
    static int[] diff;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            n = Integer.parseInt(br.readLine());
            diff = new int[5002]; // 누적합 특성상 end + 1 부분을 감소시키니까 5000나왔을때 안터지게 하기 위해 한 칸 더 주기

            for (int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                diff[start]++;
                diff[end + 1]--;
            }
            int[] cnt = new int[5001];
            int sum = 0;
            for (int i = 0; i < 5001; i++){
                sum += diff[i];
                cnt[i] = sum;
            }

            p = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");

            for (int i = 0; i < p; i++){
                int stop = Integer.parseInt(br.readLine());
                sb.append(cnt[stop]).append(" ");
            }
            System.out.println(sb);
        }

    }
}
