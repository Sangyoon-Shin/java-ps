package Greedy;

import java.io.*;
import java.util.*;

public class BOJ10162 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] time = new int[3];

        if (t % 10 != 0){
            System.out.println(-1);
            return;
        } else {
            while (t > 0){
                if (t >= 300){
                    time[0] = t / 300;
                    t %= 300;
                } else if (t >= 60){
                    time[1] = t / 60;
                    t %= 60;
                } else{
                    time[2] = t / 10;
                    t %= 10;
                }
            }
        }
        System.out.println(time[0] + " " + time[1] + " " + time[2]);

    }
}
