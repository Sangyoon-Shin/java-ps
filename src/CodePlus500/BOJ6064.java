package CodePlus500;

import java.io.*;
import java.util.*;

public class BOJ6064 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int year = 1;
            int[] cur = new int[] {1, 1};

            while (true){
                if (cur[0] == x && cur[1] == y){
                    System.out.println(year);
                    break;
                }
                else if (cur[0] == m && cur[1] == n){
                    System.out.println(-1);
                    break;
                }
                else if (cur[0] < m && cur[1] < n){
                    year++;
                    cur[0]++;
                    cur[1]++;
                } else if (cur[0] == m && cur[1] < n){
                    year++;
                    cur[0] = 1;
                    cur[1]++;
                } else if (cur[0] < m && cur[1] == n){
                    year++;
                    cur[0]++;
                    cur[1] = 1;
                }
            }
        }
    }
}
