package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ11724 {
    static ArrayList<Integer>[] g;
    static boolean visited[];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        g = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++){
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++){
            s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            g[u].add(v);
            g[v].add(u);
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++){
            if (!visited[i]){
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(int start){
        if (visited[start]){
            return;
        }
        visited[start] = true;
        for (int i : g[start]){
            if (!visited[i]){
                dfs(i);
            }
        }
    }
}
