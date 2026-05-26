package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA1221 {
    static int t, n;
    static String[] str = new String[] {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
    static Map<String, Integer> map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new HashMap<>();
        for (int i = 0; i < 10; i++){
            map.put(str[i], i);
        }

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            String info = st.nextToken();
            n = Integer.parseInt(st.nextToken());
            int[] num = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++){
                String cur = st.nextToken();
                num[i] = map.get(cur);
            }

            Arrays.sort(num);
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");

            for (int i = 0; i < n; i++){
                sb.append(str[num[i]]).append(" ");
            }
            sb.append('\n');
            System.out.println(sb);
        }
    }
}
