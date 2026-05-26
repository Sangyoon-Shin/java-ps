package SWEA.D4;

import java.io.*;
import java.util.*;

public class SWEA1238 {
    static ArrayList<Integer>[] info;
    static int len, start;
    static ArrayDeque<int[]> q;
    static ArrayList<Integer> candidate;
    static boolean[] visited;
    static int order, max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++){
            st = new StringTokenizer(br.readLine());
            len = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());

            info = new ArrayList[101];
            q = new ArrayDeque<>();
            candidate = new ArrayList<>();
            visited = new boolean[101];
            order = 1; max = 1;

            for (int i = 1; i <= 100; i++){
                info[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            int from = 0;
            for (int i = 0; i < len; i++){
                if (i % 2 == 0){
                    from = Integer.parseInt(st.nextToken());
                } else {
                    info[from].add(Integer.parseInt(st.nextToken()));
                }
            }

            visited[start] = true;
            for (int i = 0; i < info[start].size(); i++){
                int val = info[start].get(i);
                q.addLast(new int[] {val, order});
                visited[val] = true;
                candidate.add(val);
            }
            bfs();

            Collections.sort(candidate);
            int res = candidate.get(candidate.size() - 1);
            System.out.println("#" + tc + " " + res);

        }
    }
    public static void bfs(){

        while (!q.isEmpty()){
            int[] cur = q.removeFirst();
            int start = cur[0];
            int order = cur[1];
            for (int i = 0; i < info[start].size(); i++){
                if (!visited[info[start].get(i)]){
                    q.addLast(new int[] {info[start].get(i), order + 1});
                    visited[info[start].get(i)] = true;
                    if (order + 1 > max){
                        max = order + 1;
                        candidate.clear();
                        candidate.add(info[start].get(i));
                    } else if (order + 1 == max){
                        candidate.add(info[start].get(i));
                    }
                }
            }
        }
    }
}
