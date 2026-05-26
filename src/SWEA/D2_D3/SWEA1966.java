package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA1966 {
    static int t, n;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            System.out.print("#" + tc + " ");
            for (int value : arr){
                System.out.print(value + " ");
            }
            System.out.println();
        }

    }
}
