package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA21425 {
    static int t, cnt;
    static long x, y, n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            cnt = 0;
            solve(x, y);
            System.out.println(cnt);
        }
    }
    public static void solve(long x, long y){
        cnt++;
        if (x + y > n){
            return;
        }
        if (x >= y){
            solve(x, x + y);
        } else {
            solve(x + y, y);
        }
    }
}
