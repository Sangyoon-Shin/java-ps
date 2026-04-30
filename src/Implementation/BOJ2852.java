package Implementation;

import java.io.*;
import java.util.*;

public class BOJ2852 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] score = new int[2];
        int[] time = new int[2];
        int winningTeam = -1;
        int prev = 0;

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken()) - 1;
            String[] t = st.nextToken().split(":");
            int h = Integer.parseInt(t[0]);
            int m = Integer.parseInt(t[1]);
            int curTime = h * 60 + m;

            score[team]++;
            if (score[0] > score[1]){
                if (winningTeam == 0){
                    continue;
                } else {
                    prev = curTime;
                    winningTeam = 0;
                }
            } else if (score[0] < score[1]){
                if (winningTeam == 1){
                    continue;
                } else {
                    prev = curTime;
                    winningTeam = 1;
                }
            } else {
                time[winningTeam] += curTime - prev;
                winningTeam = -1;
            }
        }

        if (winningTeam != -1) {
            time[winningTeam] += 2880 - prev;
        }
        System.out.println(String.format("%02d", time[0] / 60) + ":" + String.format("%02d", time[0] % 60));
        System.out.println(String.format("%02d", time[1] / 60) + ":" + String.format("%02d", time[1] % 60));
    }
}
