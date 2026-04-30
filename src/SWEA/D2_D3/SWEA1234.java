package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA1234 {
    static int n;
    static String secret;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            secret = st.nextToken();

            ArrayDeque<Integer> q = new ArrayDeque<>();

            for (int i = 0; i < n; i++){
                q.addLast(secret.charAt(i) - '0');
            }
            ArrayDeque<Integer> res = new ArrayDeque<>();
            while (!q.isEmpty()){
                if (res.isEmpty()){
                    res.addLast(q.removeFirst());
                }
                if (res.peekLast() == q.peekFirst()){
                    res.removeLast();
                    q.removeFirst();
                } else {
                    res.addLast(q.removeFirst());
                }

            }

            StringBuilder sb = new StringBuilder();
            while (!res.isEmpty()){
                sb.append(res.removeFirst());
            }
            System.out.println("#" + tc + " " + sb);
        }
    }
}
