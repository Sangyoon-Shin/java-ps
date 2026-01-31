package CodePlus300;

import java.io.*;
import java.util.*;

public class BOJ6588 {
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> primes = new ArrayList<>();

        int max = 0;

        while (true){
            int n = Integer.parseInt(br.readLine());
            if (n == 0){
                break;
            } else {
                arr.add(n);
                if (n > max){
                    max = n;
                }
            }
        }

        // 체는 최대값 기준으로 한 번만 만들면 될 듯.
        isPrime = new boolean[max + 1];
        for (int i = 0; i <= max; i++){
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

        for (int i = 2; i <= max; i++){
            if (isPrime[i]){
                primes.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int n : arr) {
            for (int prime : primes) {
                if (prime > n / 2) {
                    break;
                } else if (isPrime[n - prime]) { // n = n - p + p
                    sb.append(n).append(" = ").append(prime).append(" + ").append(n - prime).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
