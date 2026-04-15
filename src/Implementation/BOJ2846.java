package Implementation;

import java.io.*;
import java.util.*;

public class BOJ2846 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] h = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++){
            h[i] = Integer.parseInt(st.nextToken());
        }

        int start = h[0];
        int max = 0;
        int prev = h[0];

        for (int i = 1; i < n; i++){
            int cur = h[i];
            if (prev >= h[i]){
                start = cur;
            }
            if (start < cur){
                if (cur - start > max){
                    max = cur - start;
                }
            } else {
                start = cur;
            }
            prev = cur;
        }
        System.out.println(max);
    }
}
