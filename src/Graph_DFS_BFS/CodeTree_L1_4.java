package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class CodeTree_L1_4 {
    static int n;
    static int res;
    static ArrayList<int[]> dir = new ArrayList<>();
    static ArrayList<int[]> comb = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            dir.add(new int[] {s, e});
        }

        res = 1;
        for (int i = 0; i < n; i++){
            dfs(i, 0);
        }
    }
    // 나를 포함시키고 넘어갈지, 그냥 넘어갈지
    public static void dfs(int start, int depth){
        for (int i = start + 1; i < n; i++){
            dfs(i, depth + 1);
        }
    }
}
