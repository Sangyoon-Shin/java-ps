package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ6593 {
    static char[][][] map;
    static boolean[][][] visited;
    static int[][][] time;
    static ArrayDeque<int[]> q;
    static boolean isPossible;
    static int[] dl = {1, -1, 0, 0, 0, 0};
    static int[] dr = {0, 0, 1, -1, 0, 0};
    static int[] dc = {0, 0, 0, 0, -1, 1};
    static int[] endPoint;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String[] num = br.readLine().split(" ");
            int l, r, c;
            l = Integer.parseInt(num[0]);
            r = Integer.parseInt(num[1]);
            c = Integer.parseInt(num[2]);

            if (l == 0 && r == 0 && c == 0){
                return;
            } else {
                map = new char[l][r][c];
                visited = new boolean[l][r][c];
                time = new int[l][r][c];
                q = new ArrayDeque<>();
                isPossible = false;

                for (int i = 0; i < l; i++){
                    for (int x = 0; x < r; x++){
                        String s = br.readLine();
                        for (int y = 0; y < c; y++){
                            map[i][x][y] = s.charAt(y);
                            if(map[i][x][y] == 'S' || map[i][x][y] == '.' || map[i][x][y] == 'E') {
                                time[i][x][y] = 0;
                            } else {
                                time[i][x][y] = -1;
                            }
                        }
                    }
                    String s = br.readLine();
                }

                for (int i = 0; i < l; i++){
                    for (int x = 0; x < r; x++){
                        for (int y = 0; y < c; y++){
                            if (map[i][x][y] == 'S'){
                                q.addLast(new int[] {i, x, y});
                                visited[i][x][y] = true;
                                bfs(l, r, c);
                            }
                        }
                    }
                }
                if(!isPossible){
                    System.out.println("Trapped!");
                }
            }
        }
    }
    static private void bfs(int l, int r, int c){
        while(!q.isEmpty()){
            int[] cur = q.removeFirst();
            for (int i = 0; i < 6; i++){
                int ddl = cur[0] + dl[i];
                int ddr = cur[1] + dr[i];
                int ddc = cur[2] + dc[i];
                if (ddl >= 0 && ddl < l && ddr >= 0 && ddr < r && ddc >= 0 && ddc < c){
                    if (map[ddl][ddr][ddc] == 'E' && !visited[ddl][ddr][ddc]){
                        isPossible = true;
                        System.out.println("Escaped in " + (time[cur[0]][cur[1]][cur[2]] + 1 ) + " minute(s).");
                        return;
                    }
                    if (time[ddl][ddr][ddc] >= 0 && !visited[ddl][ddr][ddc]){
                        q.addLast(new int[] {ddl, ddr, ddc});
                        visited[ddl][ddr][ddc] = true;
                        time[ddl][ddr][ddc] = time[cur[0]][cur[1]][cur[2]] + 1;
                    }
                }
            }

        }
    }
}
