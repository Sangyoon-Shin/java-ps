package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1225 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++){
            int n = Integer.parseInt(br.readLine());
            ArrayDeque<Integer> data = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 8; i++){
                data.addLast(Integer.parseInt(st.nextToken()));
            }

            boolean quit = false;
            while (true){
                if (quit){
                    break;
                }
                for (int i = 1; i <= 5; i++){
                    int cur = data.removeFirst() - i;
                    if (cur <= 0){
                        data.addLast(0);
                        quit = true;
                        break;
                    } else {
                        data.addLast(cur);
                    }
                }
            }
            System.out.print("#" + tc + " ");
            for (int i = 0; i < 8; i++){
                System.out.print(data.removeFirst() + " ");
            }
            System.out.println();
        }
    }
}
