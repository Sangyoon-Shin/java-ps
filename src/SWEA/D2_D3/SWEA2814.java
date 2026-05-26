package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA2814 {
    static int t, n, m;
    static ArrayList<Integer>[] graph;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            max = 0;

            graph = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                graph[v].add(w);
                graph[w].add(v);
            }

            System.out.println("==== 테스트케이스 " + tc + " ====");

            for (int i = 1; i <= n; i++) {
                boolean[] visited = new boolean[n + 1];
                ArrayList<Integer> path = new ArrayList<>();

                System.out.println("[시작 정점: " + i + "]");
                dfs(i, 1, visited, path);
            }

            System.out.println("#" + tc + " " + max);
        }
    }

    public static void dfs(int start, int len, boolean[] visited, ArrayList<Integer> path) {
        visited[start] = true;
        path.add(start);

        max = Math.max(max, len);

        // 현재까지 만들어진 경로 출력
        System.out.println(path + " / 길이: " + len);

        for (Integer next : graph[start]) {
            if (!visited[next]) {
                dfs(next, len + 1, visited, path);
            }
        }

        // 백트래킹
        visited[start] = false;
        path.remove(path.size() - 1);
    }
}