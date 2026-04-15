package HashMap;

import java.io.*;
import java.util.*;

public class BOJ14425 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++){
            map.put(br.readLine(), 0);
        }

        int cnt = 0;
        for (int i = 0; i < m; i++){
            if (map.get(br.readLine()) != null){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
