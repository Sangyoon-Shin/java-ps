package CodePlus300;

import java.io.*;
import java.util.*;

public class BOJ10872 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res = factorial(n);
        System.out.println(res);
    }
    static private int factorial(int n){
        if (n == 0){
            return 1;
        }
        if (n <= 2){
            return n;
        } else {
            return factorial(n - 1) * n;
        }
    }
}
