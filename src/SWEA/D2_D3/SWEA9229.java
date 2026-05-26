package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA9229 {
    static int t, n, limit;
    static int[] weight;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t ; tc++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            limit = Integer.parseInt(st.nextToken());

            weight = new int[n];
            int max = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++){
                weight[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(weight);
            int start = 0;
            int end = weight.length - 1;

            while (start < end){
                int cur = weight[start] + weight[end];
                if (limit == cur){
                    max = cur;
                    break;
                }
                if (cur > limit){
                    end--;
                } else {
                    start++;
                }
                if (cur > max && cur < limit){
                    max = cur;
                }
            }
            if (max == 0) max = -1;
            System.out.println("#" + tc + " " + max);
        }
    }
}
