package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ13549 {
    static final int MAX = 100_101;
    static int[] map = new int[MAX];
    static boolean[] visited = new boolean[MAX];
    static int[] direction = {1, -1, 2};
    static int n, k;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs(n);
        System.out.println(map[k]);

    }
    static private void bfs(int start){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        q.addLast(start);

        while (!q.isEmpty()){
            int cur = q.removeFirst();
            for (int i = 0; i < 3; i++){
                int next;
                if (i == 2){
                    next = cur * direction[2];
                } else {
                    next = cur + direction[i];
                }
                if (next >= 0 && next < MAX){
                    if (!visited[next]){
                        q.addLast(next);
                        visited[next] = true;
                        if (next == cur * direction[2]){
                            map[next] = map[cur];
                        } else{
                            map[next] = map[cur] + 1;
                        }
                    }
                }
            }
        }
    }
}
