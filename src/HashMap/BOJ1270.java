package HashMap;

import java.util.*;
import java.io.*;

public class BOJ1270 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            HashMap<Long, Integer> map = new HashMap<>();
            for (int j = 0; j < num; j++){
                long cur = Long.parseLong(st.nextToken());
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
            Set<Long> cand = new HashSet<>();
            for (long key : map.keySet()){
                if (map.get(key) > (num / 2)){
                    cand.add(key);
                }
            }
            if (cand.size() == 1){
                for (long res : cand){
                    System.out.println(res);
                }
            } else {
                System.out.println("SYJKGW");
            }
        }
    }
}
