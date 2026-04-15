package HashMap;

import java.io.*;
import java.util.*;

public class BOJ1269 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n; i++){
            map.put(Integer.parseInt(st.nextToken()), 0);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++){
            Integer val = Integer.parseInt(st.nextToken());
            if (map.get(val) != null){
                map.remove(val);
            } else {
                map.put(val, 0);
            }
        }
        System.out.println(map.size());
    }
}
