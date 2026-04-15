package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1959 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arr1 = new int[n];
            int[] arr2 = new int[m];

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++){
                arr1[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++){
                arr2[j] = Integer.parseInt(st.nextToken());
            }

            int res = 0;
            if (n < m){
                int cnt = 0;
                for (int j = 0; j < m - n + 1; j++){
                    int sum = 0;
                    for (int k = 0; k < n; k++){
                        sum += (arr1[k] * arr2[k + cnt]);
                    }
                    cnt++;
                    res = Math.max(res, sum);
                }
            } else if (n > m){
                int cnt = 0;
                for (int j = 0; j < n - m + 1; j++){
                    int sum = 0;
                    for (int k = 0; k < m; k++){
                        sum += (arr2[k] * arr1[k + cnt]);
                    }
                    cnt++;
                    res = Math.max(res, sum);
                }
            } else {
                for (int j = 0; j < n; j++){
                    res += (arr1[j] * arr2[j]);
                }
            }
            System.out.println("#" + i + " " + res);

        }
    }
}
