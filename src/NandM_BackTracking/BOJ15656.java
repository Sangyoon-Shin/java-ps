package NandM_BackTracking;

import java.io.*;
import java.util.*;

public class BOJ15656 {
    static int n, m;
    static int[] num;
    static int[] res;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n];
        res = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        dfs(0, 0);
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
        for (int i = 0; i < n; i++){
            res[depth] = num[i];
            dfs(i, depth + 1);
        }
    }
}
