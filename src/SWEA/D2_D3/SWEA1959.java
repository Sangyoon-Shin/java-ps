package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA1959 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arr1 = new int[n];
            int[] arr2 = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++){
                arr1[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++){
                arr2[i] = Integer.parseInt(st.nextToken());
            }

            int[] shortArr, longArr;

            if (n >= m){
                shortArr = arr2;
                longArr = arr1;
            } else {
                shortArr = arr1;
                longArr = arr2;
            }

            int res = Integer.MIN_VALUE;
            for (int i = 0; i <= longArr.length - shortArr.length; i++){
                int sum = 0;
                for (int j = 0; j < shortArr.length; j++){
                    sum += shortArr[j] * longArr[j + i];
                }
                res = Math.max(res, sum);
            }
            System.out.println("#" + tc + " " + res);
        }
    }
}
