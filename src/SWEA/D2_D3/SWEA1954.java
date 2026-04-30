package SWEA.D2_D3;

import java.io.*;

public class SWEA1954 {
    static int[][] arr;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++){
            int n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            draw(n);
            System.out.println("#" + i);
            show(n);
        }
    }
    public static void draw(int n){
        int start = 1;
        int max = n * n;
        int bottom = 0;
        int top = n - 1;
        int left = 0;
        int right = n - 1;

        while (start <= max){
            for (int c = left; c <= right; c++){
                arr[bottom][c] = start;
                start++;
            }
            bottom++;

            for (int r = bottom; r <= top; r++){
                arr[r][right] = start;
                start++;
            }
            right--;

            for (int c = right; c >= left; c--){
                arr[top][c] = start;
                start++;
            }
            top--;

            for (int r = top; r >= bottom; r--){
                arr[r][left] = start;
                start++;
            }
            left++;
        }
    }

    public static void show(int n){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
