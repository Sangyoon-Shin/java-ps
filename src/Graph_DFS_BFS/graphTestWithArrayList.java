package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class graphTestWithArrayList {
    static ArrayList<Integer>[] g;
    static boolean visited[];

    public static void main(String[] args) throws IOException{
        int vertex = 5; // 정점 개수
        g = new ArrayList[vertex + 1]; // g에다가 vertex + 1개 만큼의 공간 만들고.
        visited = new boolean[vertex + 1];

        for (int i = 1; i <= vertex; i++){
            g[i] = new ArrayList<>(); // 만들어둔 공간에다가 1 ~ vertex 인덱스 까지에 ArrayList 타입으로 초기화
        }

        g[1].add(2);
        g[1].add(3);
        g[1].add(4);

        g[2].add(3);
        g[2].add(5);

        g[3].add(4);
        g[3].add(5);

        g[5].add(1);

        for (int i = 1; i <= vertex; i++){
            System.out.println(i + ": " +g[i]);
        }
        for (int i = 1; i <= vertex; i++){
            for (int j = 0; j < g[i].size(); j++){
                System.out.print(g[i].get(j) + " ");
            }
            System.out.println();
        }
        dfs(1);
    }
    private static void dfs(int start){
        visited[start] = true;
        System.out.println("현재 방문하는 노드는: " + start);
        for (int i : g[start]){ // g[start] 에는 start와 인접한 노드에 대한 정보가 ArrayList 형식으로 저장되어 있으니까
            if (!visited[i]){ // 방문한 적 없으면 여기서 또 dfs 해주기
                dfs(i);
            }
        }
    }
}
