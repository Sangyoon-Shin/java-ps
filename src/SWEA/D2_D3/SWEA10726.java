package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA10726 {
    static int t, n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            String cur = Integer.toBinaryString(m);

            boolean isPossible = true;

            if (cur.length() < n){
                System.out.println("#" + tc + " OFF");
            } else {
                for (int i = cur.length() - n; i < cur.length(); i++){
                    if (cur.charAt(i) == '0'){
                        isPossible = false;
                        break;
                    }
                }
                if (isPossible){
                    System.out.println("#" + tc + " ON");
                } else {
                    System.out.println("#" + tc + " OFF");
                }
            }
        }
    }
}
