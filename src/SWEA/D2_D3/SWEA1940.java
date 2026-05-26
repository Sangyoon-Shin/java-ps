package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA1940 {
    static int t, n, command, how;
    static int speed, dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            speed = 0;
            dist = 0;

            n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());

                int command = Integer.parseInt(st.nextToken());
                if (command == 0){
                    dist += speed;
                    continue;
                } else {
                    how = Integer.parseInt(st.nextToken());
                    if (command == 1){
                        speed += how;
                    } else {
                        speed -= how;
                        if (speed < 0){
                            speed = 0;
                        }
                    }
                    dist += speed;
                }
            }
            System.out.println("#" + tc + " " + dist);
        }
    }
}
