package SWEA.D2_D3;

import java.io.*;

public class SWEA1288 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++){
            long n = Long.parseLong(br.readLine());
            System.out.println("#" + tc + " " + solve(n));
        }
    }
    public static long solve(long n){
        int[] cnt = new int[10];
        long num = n;

        int res = 0;
        for (int i = 1; i <= 1_000_000; i++){
            String str = String.valueOf(num);
            res = i;
            for (int j = 0; j < str.length(); j++){
                int idx = str.charAt(j) - '0';
                cnt[idx]++;
            }
            boolean flag = true;
            for (int id = 0; id < 10; id++){
                if (cnt[id] == 0){
                    flag = false;
                    break;
                }
            }

            if (flag){
                break;
            } else {
                num = n * (i + 1);
            }
        }
        return num;
    }
}
