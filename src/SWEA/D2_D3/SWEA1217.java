package SWEA.D2_D3;

import java.util.Scanner;

public class SWEA1217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++){
            int t = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();

            System.out.println("#" + tc + " " + cal(n, m, 1, n));
        }
    }
    public static int cal(int n , int m, int turn, int cur){
        if (m == turn){
            return cur;
        }
        return cal(n, m, turn + 1, cur * n);
    }
}
