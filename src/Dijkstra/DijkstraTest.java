package Dijkstra;

import java.io.*;
import java.util.*;

public class DijkstraTest {
    public static class Node{
        int idx;
        int cost;
        Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
    public static void doDijkstra(int n, int start){
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()){
            int curVertex = pq.poll().idx;

            if (visited[curVertex]) continue;
            visited[curVertex] = true;

            for (Node next : graph[curVertex]){
                if (dist[next.idx] > dist[curVertex] + next.cost){
                    dist[next.idx] = dist[curVertex] + next.cost;
                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        for (int i = 1; i <= n; i++){
            if (dist[i] == INF) System.out.println(0 + " ");
            else System.out.println(dist[i] + " ");
        }
    }

    public static ArrayList<Node>[] graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        System.out.println("정점 개수 입력");
        int n = Integer.parseInt(br.readLine());
        System.out.println("간선 개수 입력");
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++){
            System.out.println((i + 1) + "번째 간선정보를 입력하세요.(시작, 도착, 비용)");
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[v].add(new Node(w, cost));
        }

        System.out.println("시작 지점을 입력하세요.");
        int start = Integer.parseInt(br.readLine());
        doDijkstra(n, start);
    }
}
