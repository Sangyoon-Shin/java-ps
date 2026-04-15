package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ4179 {
        static int n, m;
        static int[][] fireMap;
        static int[][] humanMap;
        static boolean[][] visited;
        static final int MAX = Integer.MAX_VALUE;
        static int[] dr = {-1, 1, 0, 0};
        static int[] dc = {0, 0, -1, 1};
        static ArrayDeque<int[]> q = new ArrayDeque<>();
        static boolean isPossible = false;
        static int[] curPos;
        static int minTime = MAX;
        static boolean isFire = false; // 불 안 난 케이스도 처리해야함

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        fireMap = new int[n][m];
        humanMap = new int[n][m];
        visited = new boolean[n][m];


        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                fireMap[i][j] = MAX;
                humanMap[i][j] = MAX;
            }
        }

        for (int i = 0; i < n; i++){
            String info = br.readLine();
            for (int j = 0; j < m; j++){
                if (info.charAt(j) == 'F'){
                    isFire = true;
                    fireMap[i][j] = 0;
                    visited[i][j] = true;
                    q.addLast(new int[] {i, j});
                }
                if (info.charAt(j) == '.'){
                    fireMap[i][j] = 0;
                    humanMap[i][j] = 0;
                }
                if (info.charAt(j) == 'J'){
                    humanMap[i][j] = 0;
                    fireMap[i][j] = 0;
                    curPos = new int[] {i, j}; // 인간 위치 저장
                }
            }
        }

        // 먼저 불 난 곳에서 부터 동시에 bfs 돌려서 각 지점까지 불이 붙는 시간 구해놓기
        bfsFire();

        // 이제 사람을 움직일 때 불이 붙는데 걸린 시간과 이동할 때 걸리는 시간 비교하면서 탈출 여부 판단하기
        visited = new boolean[n][m];
        visited[curPos[0]][curPos[1]] = true;
        q.clear();
        q.addLast(curPos);
        bfsHuman();

        if (!isPossible){
            System.out.println("IMPOSSIBLE");
        }

    }
    static private void bfsFire(){
        while (!q.isEmpty()){
            int[] cur = q.removeFirst();
            for (int i = 0; i < 4; i++){
                int ddr = cur[0] + dr[i];
                int ddc = cur[1] + dc[i];
                if (ddr >= 0 && ddr < n && ddc >= 0 && ddc < m){
                    if (fireMap[ddr][ddc] == 0 && !visited[ddr][ddc]){
                        visited[ddr][ddc] = true;
                        fireMap[ddr][ddc] = fireMap[cur[0]][cur[1]] + 1;
                        q.addLast(new int[] {ddr, ddc});
                    }
                }
            }
        }
    }
    static private void bfsHuman(){
        while (!q.isEmpty()){
            int[] cur = q.removeFirst();
            for (int i = 0; i < 4; i++){
                int ddr = cur[0] + dr[i];
                int ddc = cur[1] + dc[i];
                if (ddr < 0 || ddr >= n || ddc < 0 || ddc >= m){
                    System.out.println(humanMap[cur[0]][cur[1]] + 1);
                    isPossible = true;
                    return;
                } else {
                    if ((!visited[ddr][ddc] && fireMap[ddr][ddc] != 0 && humanMap[ddr][ddc] != MAX )){ // 방문한 적 없고 불난 지점, 벽 아닌 곳으로 가기
                        if (fireMap[ddr][ddc] > humanMap[cur[0]][cur[1]] + 1){ // 현재 지점에서 1초 지난 시간보다 불붙는 시간이 크면 이동 가능
                            visited[ddr][ddc] = true;
                            q.addLast(new int[] {ddr, ddc});
                            humanMap[ddr][ddc] = humanMap[cur[0]][cur[1]] + 1;
                        }
                    }
                    if (!isFire){
                        if(!visited[ddr][ddc] && humanMap[ddr][ddc] != MAX){
                            visited[ddr][ddc] = true;
                            q.addLast(new int[] {ddr, ddc});
                            humanMap[ddr][ddc] = humanMap[cur[0]][cur[1]] + 1;
                        }
                    }
                }
            }
        }
    }
}
