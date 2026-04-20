package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1220 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++){
            int n = Integer.parseInt(br.readLine());

            int[][] matrix = new int[100][100];
            for (int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++){
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int res = 0;
            for (int i = 0; i < n; i++){
                ArrayDeque<Integer> s = new ArrayDeque<>();
                int cur = 0;
                for (int j = 0; j < n; j++){
                    if (matrix[j][i] == 1){
                        if (s.isEmpty()){
                            s.addLast(1);
                        } else {
                            s.clear();
                            s.addLast(1);
                        }
                    } else if (matrix[j][i] == 2){
                        if (!s.isEmpty() && s.peekLast() == 1){
                            cur++;
                            s.addLast(2);
                        }
                    }
                }
                res += cur;
            }
            System.out.println("#" + tc + " " + res);
        }
    }
}
