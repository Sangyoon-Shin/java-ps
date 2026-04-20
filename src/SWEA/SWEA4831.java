package SWEA;

import java.io.*;
import java.util.*;

public class SWEA4831 {
    static int t;
    static int k, n, m;
    static int[] elec;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            elec = new int[m + 2];
            st = new StringTokenizer(br.readLine());

            elec[0] = 0;
            for (int i = 1; i <= m; i++){
                elec[i] = Integer.parseInt(st.nextToken());
            }
            elec[m + 1] = n;

            int start = 0;
            int prev = 0;
            int cnt = 0;
            boolean isPossible = true;
            while (true){
                if (elec[m + 1] - elec[start] <= k){
                    break;
                }
                if (!isPossible){
                    break;
                }
                for (int i = start + 1; i < m + 2; i++){
                    if (elec[i] - elec[start] > k){
                        prev = start;
                        start = i - 1;
                        if (prev == start){
                            isPossible = false;
                            break;
                        }
                        cnt++;
                        break;
                    }
                }
            }
            if (isPossible){
                System.out.println("#" + tc + " " + cnt);
            } else {
                System.out.println("#" + tc + " " + 0);
            }
        }

    }
}
