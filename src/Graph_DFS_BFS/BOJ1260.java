package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ1260 {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= n; i++){
            Collections.sort(graph[i]);
        }

        sb = new StringBuilder();
        dfs(start);
        System.out.println(sb);

        visited = new boolean[n + 1];
        sb = new StringBuilder();
        bfs(start);
        System.out.println(sb);
    }
    static private void dfs(int start){
        visited[start] = true;
        sb.append(start).append(" ");

        for (int i : graph[start]){
            if(!visited[i]){
                dfs(i);
            }
        }
    }

    static private void bfs(int start){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        q.addLast(start);

        while (!q.isEmpty()){
            int cur = q.removeFirst();
            sb.append(cur).append(" ");

            for (int i : graph[cur]){
                if (!visited[i]){
                    visited[i] = true;
                    q.addLast(i);
                }
            }
        }


    }
}
