package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA26502 {
    static int t, n;
    static ArrayList<int[]> point;
    static ArrayList<int[]> candidate;
    static int res;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            n = Integer.parseInt(br.readLine());
            point = new ArrayList<>();
            candidate = new ArrayList<>();
            res = 0;

            for (int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                point.add(new int[] {a, b});
            }
            dfs(0, 3);
        }
    }
    public static void dfs(int start, int len){
        if (candidate.size() == len){
            cal(candidate);
            return;
        }
        for (int i = start; i < n; i++){
            candidate.add(point.get(i));
            dfs(i + 1, 3);
            candidate.remove(candidate.size() - 1);
        }
    }
    public static void cal(ArrayList<int[]> arr){
        int[] p1 = arr.get(0);
        int[] p2 = arr.get(1);
        int[] p3 = arr.get(2);

        
    }
}
