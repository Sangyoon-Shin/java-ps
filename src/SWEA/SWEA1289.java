package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1289 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++){
            String s = br.readLine();
            int[] bit = new int[s.length()];

            for (int i = 0; i < s.length(); i++){
                bit[i] = s.charAt(i) - '0';
            }

            // 1이 최초로 나온 시점부터 1 -> 0, 0 -> 1로 바뀐 횟수 + 1
            int cnt = 0;
            int start = 0;
            boolean flag = false;
            for (int i = 0; i < bit.length; i++){
                if (bit[i] == 1){
                    start = i + 1;
                    flag = true;
                    break;
                }
            }

            if (!flag){
                System.out.println("#" + tc + " " + 0);
                continue;
            }
            if (start == bit.length){
                System.out.println("#" + tc + " " + (cnt + 1));
            } else {
                for (int i = start; i < bit.length; i++){
                    if (flag){
                        if (bit[i] == 0){
                            flag = false;
                            cnt++;
                        }
                    } else {
                        if (bit[i] == 1){
                            flag = true;
                            cnt++;
                        }
                    }
                }
                System.out.println("#" + tc + " " + (cnt + 1));
            }

        }

    }
}
