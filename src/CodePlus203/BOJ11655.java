package CodePlus203;

import java.io.*;
import java.util.*;

public class BOJ11655 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                if (s.charAt(i) + 13 > 'Z'){
                    sb.append((char)('A' + ((s.charAt(i) - 'A' + 13) % 26)));
                } else {
                    sb.append((char)(s.charAt(i) + 13));
                }
            } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                if (s.charAt(i) + 13 > 'z'){
                    sb.append((char)('a' + (s.charAt(i) - 'a' + 13) % 26));
                } else {
                    sb.append((char)(s.charAt(i) + 13));
                }
            }
            else if (s.charAt(i) == ' ' || (s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb);
    }
}
