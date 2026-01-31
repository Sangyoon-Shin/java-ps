package CodePlus301;

import java.io.*;
import java.util.*;

public class BOJ2089 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        if (n == 0){
            System.out.println(0);
            return;
        } else {
            while (n != 0){
                sb.append(Math.abs(n % -2));
                n = (int)Math.ceil((double)n / -2);
            }
        }
        sb.reverse();
        System.out.println(sb);
    }
}
