package NandM_BackTracking;

import java.io.*;
import java.util.*;

public class BOJ15654 {
    static int n, m;
    static int[] num;
    static int[] res;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n];
        res = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
        dfs(0);
        System.out.println(sb);
    }
    public static void dfs(int depth){
        if (depth == m){
            for (int v : res){
                sb.append(v).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                visited[i] = true;
                res[depth] = num[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
