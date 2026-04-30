package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA1204 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++){
            int num = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < 1000; j++){
                int val = Integer.parseInt(st.nextToken());
                map.put(val, map.getOrDefault(val, 0) + 1);
            }
            int max = 0;
            ArrayList<Integer> idx = new ArrayList<>();

            for (Integer v : map.keySet()){
                if (map.get(v) > max){
                    max = map.get(v);
                    idx.clear();
                    idx.add(v);
                } else if (map.get(v) == max){
                    idx.add(v);
                }
            }

            Collections.sort(idx, Collections.reverseOrder());
            int res = idx.get(0);

            System.out.println("#" + num + " " + res);
        }

    }
}
