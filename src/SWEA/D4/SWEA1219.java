package SWEA.D4;

import java.io.*;
import java.util.*;

public class SWEA1219 {
    static int t, n;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean isPossible;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++){
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            visited = new boolean[100];
            graph = new ArrayList[100];
            isPossible = false;

            for (int i = 0; i < 100; i++){
                graph[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0 ; i < n; i++){
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                graph[v].add(w);
            }
            visited[0] = true;
            dfs(0);

            if (isPossible){
                System.out.println("#" + tc + " " + 1);
            } else {
                System.out.println("#" + tc + " " + 0);
            }
        }
    }
    public static void dfs(int start){
        if (start == 99){
            isPossible = true;
            return;
        }
        for (Integer next : graph[start]){
            if (!visited[next]){
                visited[next] = true;
                dfs(next);
            }
        }
    }
}
