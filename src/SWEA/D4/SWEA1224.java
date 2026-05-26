package SWEA.D4;

import java.io.*;
import java.util.*;

public class SWEA1224 {
    static int n;
    static String s;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++){
            n = Integer.parseInt(br.readLine());
            s = br.readLine();

            StringBuilder sb = new StringBuilder();
            ArrayDeque<String> st = new ArrayDeque<>();

            for (int i = 0; i < n; i++){
                char cur = s.charAt(i);
                if (cur >= '0' && cur <= '9'){
                    sb.append(cur);
                } else {
                    if (st.isEmpty()){
                        st.addFirst(String.valueOf(cur));
                    } else {

                    }
                }
            }
        }

    }
}
