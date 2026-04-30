package SWEA.D2_D3;

import java.io.*;

public class SWEA2806 {
    static int n, cnt;
    static int[] status;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++){
            n = Integer.parseInt(br.readLine());
            cnt = 0;
            status = new int[n]; // 인덱스가 열, 값이 행을 의미하도록 사용
            nQueen(0);
            System.out.println("#" + tc + " " + cnt);
        }
    }
    public static void nQueen(int depth){
        if (depth == n){
            cnt++;
            // showMap();
            return;
        }
        for (int i = 0; i < n; i++){
            status[depth] = i; // depth 열에 행을 다 넣어보기
            if (available(depth)){
                nQueen(depth + 1);
            }
        }
    }
    public static boolean available(int col){
        for (int i = 0; i < col; i++){
            // 같은 행에 존재하는지 여부 확인
            if (status[col] == status[i]){
                return false;
            } else if (Math.abs(col - i) == Math.abs(status[col] - status[i])){ // 행의 차이 = 열의 차이면 같은 대각선상에 존재. (기울기가 같으니까)
                return false;
            }
        }
        return true;
    }
    public static void showMap(){
        map = new int[n][n];
        for (int i = 0; i < n; i++){
            map[status[i]][i] = 1;
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
