package Implementation;

import java.io.*;
import java.util.*;

public class BOJ2002 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Set<String>> start = new HashMap<>();
        String[] startList = new String[n];
        for (int i = 0; i < n; i++){
            String cur = br.readLine();
            startList[i] = cur;
        }
        for (int i = 0; i < n; i++){
            Set<String> cur = new HashSet<>();
            for (int j = 0; j < i; j++){
                cur.add(startList[j]);
            }
            start.put(startList[i], cur);
        }

        Map<String, Set<String>> finish = new HashMap<>();
        String[] finishList = new String[n];
        for (int i = 0; i < n; i++){
            String cur = br.readLine();
            finishList[i] = cur;
        }
        for (int i = 0; i < n; i++){
            Set<String> cur = new HashSet<>();
            for (int j = 0; j < i; j++){
                cur.add(finishList[j]);
            }
            finish.put(finishList[i], cur);
        }

        int cnt = 0;
        for (String s : finish.keySet()){
            Set<String> f = finish.get(s);
            Set<String> st = start.get(s);
            for (String cur : st){
                if (!f.contains(cur)){
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);

    }
}
