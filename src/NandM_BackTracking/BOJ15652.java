package NandM_BackTracking;

import java.io.*;
import java.util.*;

public class BOJ15652 {
    static int n, m;
    static int[] res;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        visited = new boolean[n];
        res = new int[m];

        dfs(1, 0);
        System.out.println(sb);
    }
    public static void dfs(int s, int depth){
        if (depth == m){
            for (int v : res){
                sb.append(v).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = s; i <= n; i++){
            res[depth] = i;
            dfs(i, depth + 1);
        }
    }

}
