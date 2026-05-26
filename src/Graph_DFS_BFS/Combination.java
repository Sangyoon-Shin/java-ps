package Graph_DFS_BFS;

import java.util.*;

public class Combination {
    static int[] arr = {1, 2, 3, 4};
    static ArrayList<Integer> num = new ArrayList<>();

    public static void main(String[] args) {
        dfs(0, 3);
    }

    public static void dfs(int start, int k) {
        if (num.size() == k) {
            for (int val : num) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < arr.length; i++) {
            num.add(arr[i]);
            dfs(i + 1, k);
            num.remove(num.size() - 1);
        }
    }
}