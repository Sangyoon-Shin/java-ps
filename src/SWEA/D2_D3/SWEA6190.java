package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA6190 {
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

            ArrayList<Integer> candidate = new ArrayList<>();

            for (int i = 0; i < n - 1; i++){
                for (int j = i + 1; j < n; j++){
                    if (isIncrease(arr[i] * arr[j])){
                        candidate.add(arr[i] * arr[j]);
                    }
                }
            }

            if (candidate.isEmpty()){
                System.out.println("#" + tc + " " + -1);
            } else {
                int max = 0;
                for (int i = 0; i < candidate.size(); i++){
                    if (max < candidate.get(i)){
                        max = candidate.get(i);
                    }
                }
                System.out.println("#" + tc + " " + max);
            }
        }
    }
    public static boolean isIncrease(int cur){
        String s = "" + cur;

        for (int i = 0; i < s.length() - 1; i++){
            if (s.charAt(i) > s.charAt(i + 1)){
                return false;
            }
        }
        return true;
    }
}
