package SieveOfEratosthenes;

import java.io.*;
import java.util.*;

public class BOJ9020 {
    static boolean[] isPrime;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        isPrime = new boolean[10001];

        for (int i = 0; i <= 10000; i++){
            isPrime[i] = true;
        }
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= (int)Math.sqrt(10001); i++){
            if (!isPrime[i]){
                continue;
            }
            for (int j = i * i; j <= 10000; j += i){
                isPrime[j] = false;
            }
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());

            for (int idx = n / 2; idx >= 0; idx--){
                if (isPrime[idx] && isPrime[n - idx]){
                    System.out.println(idx + " " + (n - idx));
                    break;
                }
            }
        }
    }
}
