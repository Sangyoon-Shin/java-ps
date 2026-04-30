package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class BOJ28071 {
    static int n, m, k;
    static int[] candy;
    static int res = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        candy = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            candy[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);
        System.out.println(res);
    }
    public static void dfs(int start, int total, int boxCnt){
        if (boxCnt == m){
            if (total % k == 0){
                res = Math.max(res, total);
            }
            return;
        }
        if (start >= n){
            return;
        }
        if (total % k == 0){
            res = Math.max(res, total);
        }
        dfs(start + 1, total, boxCnt); // 나를 선택하지 않고 다음 상자로 넘어가는 경우
        dfs(start, total + candy[start], boxCnt + 1); // 나를 선택했고, 나를 또 선택하는 경우
        dfs(start + 1, total + candy[start], boxCnt + 1); // 나를 선택하고 다른 상자로 넘어가는 경우
    }
}
