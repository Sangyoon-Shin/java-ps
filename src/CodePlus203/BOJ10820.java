package CodePlus203;

import java.io.*;
import java.util.*;

public class BOJ10820 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine())!= null){
            int big = 0, small = 0, num = 0, blank = 0;
            for (int i = 0; i < s.length(); i++){
                if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                    big++;
                } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                    small++;
                } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    num++;
                } else if (s.charAt(i) == ' '){
                    blank++;
                }
            }
            System.out.println(small + " " + big + " " + num + " " + blank);
        }
    }
}
