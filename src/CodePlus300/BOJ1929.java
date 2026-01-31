package CodePlus300;

import java.io.*;
import java.util.*;

public class BOJ1929 {
    static boolean[] isPrime;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        isPrime = new boolean[n + 1];

        for (int i = 0; i <= n; i++){
            isPrime[i] = true;
        }
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(n); i++){
            if (isPrime[i]){
                for (int j = i*i; j <= n; j += i){
                    isPrime[j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = m; i <= n; i++){
            if (isPrime[i]){
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }
}
