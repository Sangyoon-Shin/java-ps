package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ5014 {
    static int f, s, g, u, d;
    static int[] map;
    static boolean[] visited;
    static int[] move;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[f + 1];
        visited = new boolean[f + 1];
        move = new int[] {u, d};

        bfs(s);
        if(s == g){
            System.out.println(0);
        }
        else if (map[g] == 0){
            System.out.println("use the stairs");
        } else {
            System.out.println(map[g]);
        }
    }
    static private void bfs(int start){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        q.addLast(start);

        while (!q.isEmpty()){
            int cur = q.removeFirst();
            for (int i = 0; i < 2; i++){
                int moving;
                if (i == 0){
                    moving = cur + move[i];
                } else {
                    moving = cur - move[i];
                }
                if (moving > 0 && moving <= f && (!visited[moving])){
                    visited[moving] = true;
                    map[moving] = map[cur] + 1;
                    q.addLast(moving);
                }
            }
        }
    }
}
