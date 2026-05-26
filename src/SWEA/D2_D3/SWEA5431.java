package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA5431 {
    static int t, n, k;
    static int[] check;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            check = new int[n + 1];
            Arrays.fill(check, 1);

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++){
                check[Integer.parseInt(st.nextToken())]--;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");

            for (int i = 1; i <= n; i++){
                if (check[i] == 1){
                    sb.append(i).append(" ");
                }
            }
            System.out.println(sb);
        }
    }
}
