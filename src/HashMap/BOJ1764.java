package HashMap;

import java.io.*;
import java.util.*;

public class BOJ1764 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            String name = br.readLine();
            map.put(name, 0);
        }

        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < m; i++){
            String name = br.readLine();
            if (map.get(name) != null){
                res.add(name);
            }
        }
        Collections.sort(res);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.size(); i++){
            sb.append(res.get(i)).append("\n");
        }
        System.out.println(res.size());
        System.out.println(sb);
    }
}
