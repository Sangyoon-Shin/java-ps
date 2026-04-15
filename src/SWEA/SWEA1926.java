package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1926 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++){
            String cur = Integer.toString(i);

            boolean clap = false;
            for (int j = 0; j < cur.length(); j++){
                if (cur.charAt(j) == '3' || cur.charAt(j) == '6' || cur.charAt(j) == '9'){
                    clap = true;
                    System.out.print('-');
                }
            }
            if (!clap){
                System.out.print(cur + ' ');
            } else {
                System.out.print(' ');
            }
        }
    }
}
