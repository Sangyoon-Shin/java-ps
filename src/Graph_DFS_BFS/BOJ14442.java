package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ14442 {
    static int[][] map;
    static int[][][] dist;
    static boolean[][][] visited;
    static int n, m, k;
    static ArrayDeque<int[][]> q = new ArrayDeque<>(); // 큐를 2차원 배열로 만들어서, (x, y, 부숨 여부), (부순 횟수) 저장?ic int[] dr = {-1, 1, 0, 0};
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);

        map = new int[n][m];
        dist = new int[n][m][2]; // 여전히 부쉈냐, 안부쉈냐로 나눔. 하지만 이번엔 벽을 부순 경우의 횟수가 k번 이하인지 체크해줘야 함.
        visited = new boolean[n][m][2];

        for (int i = 0; i < n; i++){
            String cur = br.readLine();
            for (int j = 0; j < m; j++){
                map[i][j] = cur.charAt(j) - '0';
            }
        }

        dist[0][0][0] = 1;
        visited[0][0][0] = true;
        q.addLast(new int[][] {{0, 0, 0}, {0}});
        System.out.println(bfs());
    }
    public static int bfs(){

        while (!q.isEmpty()){
            int[][] cur = q.removeFirst();
            if (cur[0][0] == n - 1 && cur[0][1] == m - 1) {
                return dist[cur[0][0]][cur[0][1]][cur[0][2]];
            }
            for (int i = 0; i < 4; i++){
                int ddr = cur[0][0] + dr[i];
                int ddc = cur[0][1] + dc[i];
                int isBroken = cur[0][2];
                int times = cur[1][0];
                if (ddr < 0 || ddr >= n || ddc < 0 || ddc >= m){
                    continue;
                }
                if (map[cur[0][0]][cur[0][1]] == 0 && !visited[cur[0][0]][cur[0][1]][cur[0][2]]){
                    if (isBroken == 0){ // 다음 이동할 곳이 벽 아니고, 방문한 적 없고, 이전에 온 경로가 벽을 부순적이 없으면
                        dist[ddr][ddc][isBroken] = dist[cur[0][0]][cur[0][1]][cur[0][2]] + 1;
                        visited[ddr][ddc][isBroken] = true;
                        q.addLast(new int[][] {{ddr, ddc, isBroken}, {0}});
                    } else { // 이전에 온 경로가 벽을 부순적이 있으면? times 값이 k보다 작은지 먼저 확인하고 로직 처리
                        if (times < k){
                            dist[ddr][ddc][isBroken] = dist[cur[0][0]][cur[0][1]][1] + 1;
                            visited[ddr][ddc][1] = true;
                            times++; // 그 지점에서 벽을 부순적이 있고, 몇 번 부셨는지 알려주는 times 값 증가해서 큐에 집어넣기
                            q.addLast(new int[][] {{ddr, ddc, 1}, {times}});
                        } else {
                            continue; // 이미 k번 부셨으면 할 게 없다.
                        }
                    }
                } else if (map[cur[0][0]][cur[0][1]] == 1 && !visited[cur[0][0]][cur[0][1]][cur[0][2]]){
                    // 다음 이동할 곳이 벽이야. 그럼 이전에 벽을 부순적이 있는지, 없는지 따지고 있다면 몇 번 부숴서 온건지 체크
                    if (isBroken == 0){
                        dist[ddr][ddc][1] = dist[cur[0][0]][cur[0][1]][cur[0][2]] + 1;
                        visited[ddr][ddc][1] = true;
                        q.addLast(new int[][] {{ddr, ddc, 1}, {1}});
                    } else {
                        if (times < k){
                            dist[ddr][ddc][1] = dist[cur[0][0]][cur[0][1]][1] + 1;
                            visited[ddr][ddc][1] = true;
                            times++;
                            q.addLast(new int[][] {{ddr, ddc, 1}, {times}});
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
