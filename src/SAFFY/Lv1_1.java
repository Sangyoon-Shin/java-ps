package SAFFY;

import java.io.*;
import java.util.*;

public class Lv1_1 {
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

            int res = 0;
            for (int i = 0; i < n - 2; i++){
                for (int j = i + 2; j < n; j++){
                    if (arr[j - 2] - arr[j - 1] == -1 * (arr[j - 1] - arr[j])){
                        res = Math.max(j - i + 1, res);
                    } else {
                        break;
                    }
                }
            }
            System.out.println("#" + tc + " " + res);

        }
    }
}
