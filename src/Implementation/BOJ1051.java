package Implementation;

import java.io.*;
import java.util.*;

public class BOJ1051 {
    static int n, m;
    static int[][] matrix;
    static int res;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        matrix = new int[n][m];
        res = 1;

        for (int i = 0; i < n; i++){
            String s = br.readLine();
            for (int j = 0; j < m; j++){
                matrix[i][j] = s.charAt(j) - '0';
            }
        }

        int min = Math.min(n, m); // 어차피 정사각형 만들어야 되니까 작은 길이가 정사각형 최대 크기
        for (int len = 2; len <= min; len++){
            for (int i = 0; i < n - len + 1; i++){
                for (int j = 0; j < m - len + 1; j++){
                    int a = matrix[i][j];
                    int b = matrix[i + len - 1][j];
                    int c = matrix[i][j + len - 1];
                    int d = matrix[i + len - 1][j + len - 1];
                    if (a == b && a == c && a == d && b == c && b == d && c == d){
                        res = Math.max(res, len);
                    }
                }
            }
        }
        System.out.println(res * res);
    }
}
