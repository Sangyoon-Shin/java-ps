package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA4834 {
    static int t, n;
    static Map<Integer, Integer> map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            n = Integer.parseInt(br.readLine());
            map = new HashMap<>();

            String s = br.readLine();

            for (int i = 0; i < n; i++){
                int cur = Integer.parseInt(String.valueOf(s.charAt(i)));
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }

            int max = 0, idx = 0;

            for (int key : map.keySet()){
                if (map.get(key) > max){
                    max = map.get(key);
                    idx = key;
                } else if (map.get(key) == max){
                    if (key > idx){
                        idx = key;
                    }
                }
            }

            System.out.println("#" + tc + " " + idx + " " + max);
        }
    }
}
