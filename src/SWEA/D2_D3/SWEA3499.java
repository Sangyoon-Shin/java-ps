package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA3499 {
    static int t, n;
    static ArrayDeque<String> q1;
    static ArrayDeque<String> q2;
    static String[] res;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++){
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            q1 = new ArrayDeque<>();
            q2 = new ArrayDeque<>();

            res = new String[n];

            for (int i = 0; i < n; i++){
                if (n % 2 == 0){
                    if (i < n / 2){
                        q1.addLast(st.nextToken());
                    } else {
                        q2.addLast(st.nextToken());
                    }
                } else {
                    if (i <= n / 2){
                        q1.addLast(st.nextToken());
                    } else {
                        q2.addLast(st.nextToken());
                    }
                }

            }

            StringBuilder sb = new StringBuilder();
            while (!q1.isEmpty()){
                sb.append(q1.removeFirst()).append(" ");
                if (!q2.isEmpty()){
                    sb.append(q2.removeFirst()).append(" ");
                } else {
                    break;
                }
            }
            if (!q1.isEmpty()){
                sb.append(q1.removeFirst());
            } else {
                System.out.println("#" + tc + " " + sb);
            }

        }
    }
}
