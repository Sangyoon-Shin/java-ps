package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA1228 {
    static int len, n;
    static ArrayList<String> cypher;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++){
            len = Integer.parseInt(br.readLine());
            cypher = new ArrayList<>();

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < len; i++){
                cypher.add(st.nextToken());
            }

            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++){
                String command = st.nextToken();
                int start = Integer.parseInt(st.nextToken());
                int how = Integer.parseInt(st.nextToken());
                for (int j = 0; j < how; j++){
                    cypher.add(start, st.nextToken());
                    start++;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < 10; i++){
                sb.append(cypher.get(i)).append(" ");
            }
            System.out.println(sb);
        }
    }
}
