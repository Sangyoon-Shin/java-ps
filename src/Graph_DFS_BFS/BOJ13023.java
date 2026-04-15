package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ13023 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean find;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList
                [n];
        for (int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[n];


        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        find = false;
        int depth = 0;
        for (int i = 0; i < n; i++){
            dfs(i, depth);
        }
        if (find){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    private static void dfs(int start, int depth){
        if (find){
            return;
        }
        if (depth == 4){
            find = true;
            return;
        }
        visited[start] = true;

        for (int next : graph[start]){
            if (!visited[next]){
                dfs(next, depth + 1);
            }
            if (find){
                return;
            }
        }
        visited[start] = false;
    }
}
