package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA1229 {
    static int n, cnt;
    static LinkedList<String> origin;
    static String cur, command;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1 ; tc <= 10; tc++){
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            origin = new LinkedList<>();

            for (int i = 0; i < n; i++){
                origin.add(st.nextToken());
            }

            cnt = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < cnt; i++){
                String cur = st.nextToken();
                if (cur.equals("I")){
                    int idx = Integer.parseInt(st.nextToken());
                    int how = Integer.parseInt(st.nextToken());
                    for (int j = idx; j < idx + how; j++){
                        origin.add(j, st.nextToken());
                    }
                } else {
                    int idx = Integer.parseInt(st.nextToken());
                    int how = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < how; j++){
                        origin.remove(idx);
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");

            for (int i = 0; i < 10; i++){
                sb.append(origin.get(i)).append(" ");
            }
            System.out.println(sb);
        }
    }
}
