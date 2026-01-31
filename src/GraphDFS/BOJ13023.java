package GraphDFS;

import java.io.*;
import java.util.*;

public class BOJ13023 {
    static ArrayList<Integer>[] friend;
    static boolean[] visited;
    static boolean isExist;

    public static void main(String[] args) throws IOException{
        // 사람 수 = 노드 수, 관계 수 = 간선 수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        isExist = false; // 일단 그런 친구관계가 없는 상황
        visited = new boolean[n];
        friend = new ArrayList[n];

        for (int i = 0; i < n; i++){
            friend[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++){
            s = br.readLine().split(" ");
            int f1 = Integer.parseInt(s[0]);
            int f2 = Integer.parseInt(s[0]);

            friend[f1].add(f2);
            friend[f2].add(f1);
        }

        dfs(0);

        if (isExist){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    private static void dfs(int start){
        visited[start] = true;
        boolean flag = false;
        for (int i : friend[start]){
            if (!visited[i]){
                dfs(i);
            }
        }

    }
}
