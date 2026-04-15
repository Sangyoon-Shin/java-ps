package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1983 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            double[][] res = new double[n][3];
            for (int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                double a = Long.parseLong(st.nextToken());
                double b = Long.parseLong(st.nextToken());
                double c = Long.parseLong(st.nextToken());

                double score = a * 0.35 + b * 0.45 + c * 0.20;
                res[i][0] = i + 1;
                res[i][1] = score;
            }

            Arrays.sort(res, (a, b) -> {
                if (a[1] != b[1]) return Double.compare(b[1], a[1]);
                return Double.compare(a[0], b[0]);
            });

            for (int i = 0; i < n; i++){
                if (res[i][0] == k){
                    System.out.println("#" + tc + " " + grade[i / (n / 10)]);
                }
            }


        }



    }
}
