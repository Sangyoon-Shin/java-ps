package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ1707 {
    static ArrayList<Integer>[] g;
    static int[] check;
    static boolean[] visited;
    static boolean isPossible;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            g = new ArrayList[v + 1];
            check = new int[v + 1];
            visited = new boolean[v + 1];
            isPossible = true;

            for (int j = 1; j <= v; j++){
                g[j] = new ArrayList<Integer>();
            }

            for (int j = 0; j < e; j++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                g[start].add(end);
                g[end].add(start);
            }

            for (int j = 1; j <= v; j++){
                if (isPossible){
                    dfs(j);
                } else {
                    break;
                }
            }

            if (isPossible){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
    private static void dfs(int start){
        visited[start] = true;
        for (int i : g[start]){
            if (!visited[i]){
                check[i] = (check[start] + 1) % 2;
                dfs(i);
            } else {
                if (check[start] == check[i]){
                    isPossible = false;
                }
            }
        }
    }
}
