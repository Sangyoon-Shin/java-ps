package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1860 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] wait = new int[n];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++){
                wait[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(wait);

            ArrayDeque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++){
                q.addLast(wait[i]);
            }

            // 2초가 지나야 만들어지는데, 1초에 도착한 애가 있으면 대기시간 생기는거.
            int max = wait[n - 1];
            int bread = 0;
            boolean isPossible = true;

            for (int i = 0; i <= max; i++){
                if (i % m == 0){
                    bread += k;
                }

            }

        }
    }
}
