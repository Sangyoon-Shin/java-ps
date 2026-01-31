package CodePlus300;

import java.io.*;
import java.util.*;

public class BOJ1934 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int lcm = ((a * b) / gcd(a, b));
            System.out.println(lcm);
        }
    }
    static private int gcd(int a, int b){
        if (b == 0){
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
