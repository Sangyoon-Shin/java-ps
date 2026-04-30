package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA1859 {
    public static void main(String[] args) throws IOException{
        // 맨 뒤에서 시작해서 그걸 최대값으로 고정해두고, 최댓값보다 작은 애들은 무조건 구매
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            int[] num = new int[n];
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++){
                num[j] = Integer.parseInt(st.nextToken());
            }

            int max = num[n - 1];
            long res = 0;

            for (int j = n - 2; j >= 0; j--){
                if (max >= num[j]){
                    res += (max - num[j]);
                } else {
                    max = num[j];
                }
            }

            System.out.println("#" + (i + 1) + " " + res);
        }

    }
}
