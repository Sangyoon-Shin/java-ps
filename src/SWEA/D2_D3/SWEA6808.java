package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA6808 {
    static int t;
    static int[] g;
    static Set<Integer> set;
    static ArrayList<Integer> e;
    static int gWin, gLose;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){

            g = new int[9];
            set = new HashSet<>();
            for (int i = 1; i <= 18; i++){
                set.add(i);
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++){
                int val = Integer.parseInt(st.nextToken());
                set.remove(val);
                g[i] = val;

            }
            e = new ArrayList<>(set);

            visited = new boolean[19];
            gWin = 0; gLose = 0;
            game(0, 0, 0);

            System.out.println("#" + tc + " " + gWin + " " + gLose);
        }
    }
    public static void game(int depth, int gScore, int eScore){
        if (depth == 9){
            if (gScore > eScore){
                gWin++;
            } else if (gScore < eScore){
                gLose++;
            }
            return;
        }
        for (int i = 0; i < 9; i++){
            int val = e.get(i);
            if (!visited[val]){
                visited[val] = true;
                int sum = g[depth] + val;

                if (g[depth] > val){
                    game(depth + 1, gScore + sum, eScore);
                }  else {
                    game(depth + 1, gScore, eScore + sum);
                }
                visited[val] = false;
            }
        }
    }
}
