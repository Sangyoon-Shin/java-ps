package CodePlus300;

import java.io.*;
import java.util.*;

public class BOJ1978 {
    static int[] num;
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        num = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++){
            num[i] = Integer.parseInt(st.nextToken());
            if (max < num[i]){
                max = num[i];
            }
        }

        isPrime = new boolean[max + 1];
        for (int i = 0; i < max + 1; i++){
            isPrime[i] = true;
        }

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(max); i++){
            if (isPrime[i]){
                for (int j = i*i; j <= max; j += i){
                    isPrime[j] = false;
                }
            }

        }

        int cnt = 0;
        for (int i = 0; i < n; i++){
            if (isPrime[num[i]]){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
