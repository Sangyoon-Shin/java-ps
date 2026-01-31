import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<Integer>[] g; // 인접리스트로 그래프 표현
    static int group[]; // 각 노드에서의 group이 뭔지 표현
    static boolean visited[]; // 방문한 노드 표시
    static boolean isPossible; // 이분 그래프가 가능한지
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++){
            String[] s = br.readLine().split(" ");
            int v = Integer.parseInt(s[0]);
            int e = Integer.parseInt(s[1]);

            g = new ArrayList[v + 1];
            group = new int[v + 1];
            visited = new boolean[v + 1];
            isPossible = true;

            for (int j = 1; j <= v; j++){
                g[j] = new ArrayList<Integer>(); // g는 각각 리스트를 담을 수 있는 배열인거고, 거기다 빈 리스트 생성하도록 초기화
            }

            for (int j = 0; j < e; j++){
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                // 무방향이니까 양쪽 다 연결
                g[start].add(end);
                g[end].add(start);
            }

            // 모든 노드가 연결되어있다는 보장이 없기에, 모든 노드에 대해 순회하며 dfs 실행
            for (int j = 1; j <= v; j++){
                if (isPossible){ // 아직까진 이분 그래프가 아닌 경우를 찾지 못한 경우에 한에서만 dfs 실행
                    dfs(j); // isPossible이 false가 되는 순간 break; => 이분 그래프가 아닌 경우 찾음.
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
        visited[start] = true; // 일단 start 노드를 방문한 노드로 업데이트
        for (int i : g[start]){ // g[start]에는 결국, start 노드와 연결된 노드들의 정보가 있는 리스트가 있음. 그 리스트를 순회
            if (!visited[i]){ // 다음에 가야할 노드가 방문전이고
                group[i] = (group[start] + 1) % 2; // start가 0 그룹이었으면, i는 1그룹으로. 인접한 노드들은 서로 다른 그룹이어야 하므로
                dfs(i);
            } else {
                // 다음 가야할 노드가 이미 방문한 노드인 경우
                if (group[i] == group[start]){ // 인접한 애들끼리 같은 group인 경우에 flag 바꿔주기.
                    isPossible = false;
                }
            }
        }
    }
}