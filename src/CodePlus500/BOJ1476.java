package CodePlus500;

import java.io.*;
import java.util.*;

public class BOJ1476 {
    static int[] target = new int[3];
    static int[] cur = {1, 1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        target[0] = Integer.parseInt(s[0]);
        target[1] = Integer.parseInt(s[1]);
        target[2] = Integer.parseInt(s[2]);

        int year = 1;
        while (true){
            if (target[0] == cur[0] && target[1] == cur[1] && target[2] == cur[2]){
                System.out.println(year);
                break;
            } else {
                if (cur[0] < 15 && cur[1] < 28 && cur[2] < 19){
                    cur[0]++;
                    cur[1]++;
                    cur[2]++;
                    year++;
                } else if (cur[0] == 15 && cur[1] < 28 && cur[2] < 19){
                    cur[0] = 1;
                    cur[1]++;
                    cur[2]++;
                    year++;
                } else if (cur[1] == 28 && cur[0] < 15 && cur[2] < 19){
                    cur[1] = 1;
                    cur[0]++;
                    cur[2]++;
                    year++;
                } else if (cur[2] == 19 && cur[0] < 15 && cur[1] < 28){
                    cur[2] = 1;
                    cur[0]++;
                    cur[1]++;
                    year++;
                } else if(cur[0] == 15 && cur[1] == 28 && cur[2] < 19){
                    cur[0] = cur[1] = 1;
                    cur[2]++;
                    year++;
                } else if (cur[0] == 15 && cur[2] == 19 && cur[1] < 28){
                    cur[0] = cur[2] = 1;
                    cur[1]++;
                    year++;
                } else if (cur[1] == 28 && cur[2] == 19 && cur[0] < 15){
                    cur[0]++;
                    cur[1] = cur[2] = 1;
                    year++;
                }
                else if (cur[0] == 15 && cur[1] == 28 && cur[2] == 19){
                    cur[0] = cur[1] = cur[2] = 1;
                    year++;
                }
            }
        }


    }
}
