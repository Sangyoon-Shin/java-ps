package Greedy;

import java.io.*;
import java.util.*;

public class BOJ22864 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);
        int m = Integer.parseInt(s[3]);

        int work = 0;
        int tired = 0;

        for (int i = 0; i < 24; i++){
            if (a + tired > m){
                if (tired - c < 0){
                    tired = 0;
                } else {
                    tired -= c;
                }
            } else {
                work += b;
                tired += a;
            }
        }
        System.out.println(work);

    }
}
