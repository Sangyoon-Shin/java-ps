package Implementation;

import java.io.*;
import java.util.*;

public class BOJ1515 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int base = 1;
        int ptr = 0;

        loop:
        while (base <= 30000){
            String cur = String.valueOf(base);
            for (int i = 0; i < cur.length(); i++){
                if (cur.charAt(i) == s.charAt(ptr)){
                    ptr++;
                }
                if (ptr == s.length()){
                    System.out.println(base);
                    break loop;
                }
            }
            base++;
        }
    }
}
