package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA1945 {
    static int t, n;
    static int[] prime = new int[] {2, 3, 5, 7, 11};
    static int[] res;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            n = Integer.parseInt(br.readLine());
            res = new int[5];
            solve(n);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 5; i++){
                sb.append(res[i]).append(" ");
            }
            System.out.println("#" + tc + " " + sb);
        }
    }
    public static void solve(int num){
        while (num > 1){
            for (int i = 4; i >= 0; i--){
                if (num % prime[i] == 0){
                    res[i]++;
                    num /= prime[i];
                }
            }
        }
    }
}
