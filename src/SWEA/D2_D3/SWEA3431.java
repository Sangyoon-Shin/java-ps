package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA3431 {
    static int t, l, u, x;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            u = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            int res = 0;
            if (x < l){
                res = l - x;
            } else if (x <= u){
                res = 0;
            } else {
                res = -1;
            }
            System.out.println("#" + tc + " " + res);
        }
    }
}
