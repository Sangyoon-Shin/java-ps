package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA4828 {
    static int t, n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            n = Integer.parseInt(br.readLine());
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++){
                int val = Integer.parseInt(st.nextToken());
                if (val > max){
                    max = val;
                }
                if (val < min){
                    min = val;
                }
            }
            System.out.println("#" + tc + " " + (max - min));

        }

    }
}
