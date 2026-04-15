package Implementation;

import java.io.*;
import java.util.*;

public class BOJ32982 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] time = new int[6];
        for (int i = 0; i < 6; i++){
            time[i] = Integer.parseInt(st.nextToken());
        }

        int day = 0;
        int limit = 0;
        while (day < n){
            day++;
            for (int i = 0; i < 6; i++){

            }
        }
    }
}
