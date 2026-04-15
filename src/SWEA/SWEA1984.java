package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1984 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[10];

            for (int i = 0; i < 10; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int sum = 0;
            for (int i = 1; i < 9; i++){
                sum += arr[i];
            }
            System.out.println("#" + tc + " " + Math.round((float)sum / 8));
        }
    }
}
