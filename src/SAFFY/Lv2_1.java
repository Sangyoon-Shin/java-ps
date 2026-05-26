package SAFFY;

import java.io.*;
import java.util.*;

public class Lv2_1 {
    static int t, n, m, k;
    static int res;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            // 오답 개수는 n - m 개. 이 오답을 최대한 cnt로 인해 2배로 폭증하지 않게끔 배치하자.
            // 근데 cnt - 1 간격으로 배치를 하더라도 오답 개수가 적으면, 어느 부분은 무조건 정답이 연속한 구간이 나옴
            // 그럼 이 연속한 구간을 앞에다가 두면 작은수 * 2니까 최소한으로 증가시킬 수 있음
            int wrong = n - m;

            boolean[] p = new boolean[n];
            if (n - m <= k){
                int cnt = 0;
                for (int i = n - 1; i >= 0; i -= k){
                    if (cnt == n - m){
                        break;
                    }
                    p[i] = false;
                    cnt++;
                }
            } else {

            }




        }
    }

}
