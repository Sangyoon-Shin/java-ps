package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA25330 {
    static int n;
    static String s;
    static boolean isPossible;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= n; tc++){
            s = br.readLine();
            isPossible = true;

            int[] arr = new int[s.length()];
            int[] visited = new int[10];

            for (int i = 0; i < s.length(); i++){
                arr[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
            }

            for (int i = 0; i < s.length(); i++){
                int cur = arr[i];
                if (visited[cur] == 0){
                    visited[cur]++;
                    if (arr[i] == arr[i + 1 + cur]){
                        for (int j = i + 1; j < i + 1 + cur; j++){
                            if (arr[j] == cur){
                                isPossible = false;
                                break;
                            }
                        }
                        visited[cur]++;
                    } else {
                        isPossible = false;
                        break;
                    }
                }
            }
            for (int i = 0; i < s.length(); i++){
                if (visited[arr[i]] == 0 || visited[arr[i]] == 2){
                    continue;
                } else {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible){
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
