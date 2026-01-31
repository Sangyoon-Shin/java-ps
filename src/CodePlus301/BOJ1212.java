package CodePlus301;

import java.io.*;
import java.util.*;

public class BOJ1212 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] code = {"000","001","010","011","100","101","110","111"};

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++){
            if (i == 0 && s.charAt(i) >= '0' && s.charAt(i) <= '3'){
                String[] exceptionCode = {"0", "1", "10", "11"};
                sb.append(exceptionCode[Integer.parseInt(String.valueOf(s.charAt(i)))]);
            } else {
                sb.append(code[Integer.parseInt(String.valueOf(s.charAt(i)))]);
            }
        }
        System.out.println(sb);
    }
}
