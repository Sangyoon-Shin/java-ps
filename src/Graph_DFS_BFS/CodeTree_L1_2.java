package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class CodeTree_L1_2 {
    static int n;
    static int cnt = 0;
    static ArrayList<Integer> num = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dfs(0);
        System.out.println(cnt);

    }
    public static void dfs(int depth){
        if (depth == n){
            check();
            return;
        }
        for (int i = 1; i <= 4; i++){
            num.add(i);
            dfs(depth + 1);
            num.remove(num.size() - 1);
        }
    }
    public static void check(){
        boolean isPossible = true;
        int start = 0;

        while (start < num.size()){
            if (!isPossible){
                break;
            }
            int cnt = num.get(start);
            if (start + cnt - 1 >= num.size()){
                isPossible = false;
                break;
            }
            for (int i = start; i < start + cnt; i++){
                if (num.get(i) == cnt){
                    continue;
                } else {
                    isPossible = false;
                    break;
                }
            }
            start += cnt;
        }
        if (isPossible){
            cnt++;
        }
    }
}