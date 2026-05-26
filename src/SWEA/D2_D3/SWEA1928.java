package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA1928 {
    static int t;
    static String str;
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 26; i++){
            map.put(String.valueOf((char)('A' + i)), i);
        }
        for (int i = 26; i < 52; i++){
            map.put(String.valueOf((char)('a' + i - 26)), i);
        }
        for (int i = 0; i < 10; i++){
            map.put(String.valueOf(i), i + 52);
        }
        map.put("+", 62);
        map.put("/", 63);


        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            str = br.readLine();
            String cur = "";
            for (int i = 0; i < str.length(); i++){
                int num = map.get(String.valueOf(str.charAt(i)));
                String add = changeTo6Bits(num);
                cur += add;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cur.length(); i += 8){
                String res = "";
                for (int j = i; j < i + 8; j++){
                    res += cur.charAt(j);
                }
                sb.append((char)(Integer.parseInt(res, 2)));
            }
            System.out.println("#" + tc + " " + sb);
        }
    }
    public static String changeTo6Bits(int n){
        StringBuilder sb = new StringBuilder();

        while (n > 1){
            sb.append(n % 2);
            n /= 2;
        }
        sb.append(n);
        String cur = sb.toString();
        while (cur.length() < 6){
            cur += "0";
        }
        sb = new StringBuilder(cur);
        return sb.reverse().toString();
    }
}
