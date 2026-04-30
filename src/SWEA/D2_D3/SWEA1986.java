package SWEA.D2_D3;

import java.io.*;

public class SWEA1986 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            for (int i = 0; i < n; i++){
                arr[i] = i + 1;
            }

            int sum = 0;
            for (int i = 0; i < n; i++){
                if (arr[i] % 2 == 0){
                    sum -= arr[i];
                } else {
                    sum += arr[i];
                }
            }
            System.out.println("#" + tc + " " + sum);
        }
    }
}
