package HashMap;

import java.io.*;
import java.util.*;

public class BOJ1620 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        HashMap<Integer, String> map = new HashMap<>();
        HashMap<String, Integer> rmap = new HashMap<>();
        for (int i = 0; i < n; i++){
            String name = br.readLine();
            map.put(i + 1, name);
            rmap.put(name, i + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++){
            String name = br.readLine();
            if ((name.charAt(0) >= 'a' && name.charAt(0) <= 'z') || (name.charAt(0) >= 'A' && name.charAt(0) <= 'Z')){
                sb.append(rmap.get(name)).append("\n");
            } else {
                sb.append(map.get(Integer.parseInt(name))).append("\n");
            }
        }
        System.out.println(sb);
    }
}
