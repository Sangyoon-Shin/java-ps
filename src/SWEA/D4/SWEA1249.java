package SWEA.D4;

import java.io.*;
import java.util.*;

public class SWEA1249 {
    static int t, n;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dist;
    static PriorityQueue<Node> pq;
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};

    public static class Node{
        int r;
        int c;
        int cost;
        Node(int r, int c, int cost){
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visited = new boolean[n][n];
            pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
            dist = new int[n][n];

            int INF = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    dist[i][j] = INF;
                }
            }

            for (int i = 0; i < n; i++){
                String s = br.readLine();
                for (int j = 0; j < n; j++){
                    map[i][j] = s.charAt(j) - '0';
                }
            }
            dist[0][0] = 0;
            pq.add(new Node(0, 0, 0));

            doDijkstra();

            System.out.println("#" + tc + " " + dist[n - 1][n - 1]);
        }
    }
    public static void doDijkstra(){

        while (!pq.isEmpty()){
            Node curVertex = pq.poll();
            for (int i = 0; i < 4; i++){
                int ddr = curVertex.r + dr[i];
                int ddc = curVertex.c + dc[i];
                if (ddr >= 0 && ddr < n && ddc >= 0 && ddc < n){
                    if (visited[ddr][ddc]) continue;
                    visited[ddr][ddc] = true;
                    if (dist[ddr][ddc] > curVertex.cost + map[ddr][ddc]){
                        dist[ddr][ddc] = curVertex.cost + map[ddr][ddc];
                        pq.add(new Node(ddr, ddc, dist[ddr][ddc]));
                    }
                }
            }
        }
    }
}
