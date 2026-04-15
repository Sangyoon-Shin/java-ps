package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ1697 {
    static int[] map;
    static boolean[] visited;
    static int[] direction = {1, -1, 2};
    static int n, k;
    static final int size = 100_101;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[size];
        visited = new boolean[size];

        bfs(n);
        System.out.println(map[k]);
    }
    static private void bfs(int n){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited[n] = true;
        q.addLast(n);

        while (!q.isEmpty()){
            int cur = q.removeFirst();
            for (int i = 0; i < 3; i++){
                int next;
                if (i == 2){
                    next = cur * direction[i];
                } else {
                    next = cur + direction[i];
                }
                if (next >= 0 && next < size){
                    if (!visited[next]){
                        visited[next] = true;
                        q.addLast(next);
                        map[next] = map[cur] + 1;
                    }

                }
            }
        }
    }
}
