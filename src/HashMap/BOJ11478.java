package HashMap;

import java.io.*;
import java.util.*;

public class BOJ11478 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int len = s.length();

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j <= len; j++){
                String cur = s.substring(i, j);
                set.add(cur);
            }
        }
        System.out.println(set.size());
    }
}
