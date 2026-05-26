package SAFFY;

import java.io.*;
import java.util.*;

public class Lv1_2 {
    static int t, n, p, b;
    static int[] limit;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            limit = new int[n];
            st = new StringTokenizer(br.readLine());

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++){
                limit[i] = Integer.parseInt(st.nextToken());
                if (limit[i] > max){
                    max = limit[i];
                }
                if (limit[i] < min){
                    min = limit[i];
                }
            }

            int res = 0;
            for (int i = min; i <= max + 1; i++){
                int sum = 0;
                for (int j = 0; j < n; j++){
                    if (limit[j] < i){ // 광고수를 초과하면 p로 유료결제
                        sum += p;
                    } else {
                        sum += i * b; // 초과 안하면 광고 개수만큼 수입
                    }
                }
                res = Math.max(res, sum);
            }
            System.out.println("#" + tc + " " + res);
        }
    }
}
