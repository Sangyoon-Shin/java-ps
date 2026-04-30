package SWEA.D2_D3;

import java.io.*;
import java.util.*;
public class SWEA1208 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++){
            PriorityQueue<Integer> min = new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 100; i++){
                int cur = Integer.parseInt(st.nextToken());
                min.add(cur);
                max.add(cur);
            }

            boolean isPossible = false;
            int res = 0;
            for (int i = 0; i < n; i++){
                int curmin = min.peek();
                int curmax = max.peek();
                if (curmax - curmin <= 1){
                    isPossible = true;
                    res = curmax - curmin;
                    break;
                } else {
                    min.add(min.remove() + 1);
                    max.add(max.remove() - 1);
                }
            }
            if (isPossible){
                System.out.println("#" + tc + " " + res);
            } else {
                System.out.println("#" + tc + " " + (max.peek() - min.peek()));
            }
        }


    }
}
