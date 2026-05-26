package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA1946 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++){
            int n = Integer.parseInt(br.readLine());

            int idx = 0;
            ArrayList<String> arr = new ArrayList<>();
            for (int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                String word = st.nextToken();
                int cnt = Integer.parseInt(st.nextToken());

                for (int j = 0; j < cnt; j++){
                    arr.add(word);
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc);

            for (int i = 0; i < arr.size(); i++){
                if (i % 10 == 0){
                    sb.append('\n');
                }
                sb.append(arr.get(i));
            }
            System.out.println(sb);
        }
    }
}
