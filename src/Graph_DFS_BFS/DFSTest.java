package Graph_DFS_BFS;

import java.io.*;
import java.util.*;

public class DFSTest {
    static int n;
    static int[] board;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new int[n]; // board[0] = 1 => 0행 1열
        answer = 0;

        dfs(0);

        System.out.println(answer);
    }

    public static void dfs(int row) {
        // row == n이면 정답 증가
        if (row == n){
            answer++;
            return;
        }
        // 현재 row에서 col 0 ~ n-1까지 시도
        // 놓을 수 있으면 board[row] = col 후 dfs(row + 1)
        for (int col = 0; col < n; col++){
            if (isPossible(row, col)){
                board[row] = col;
                dfs(row + 1);
            }
        }
    }

    public static boolean isPossible(int row, int col) {
        // 이전 행들 0 ~ row - 1 검사
        for (int i = 0; i < row; i++){
            if (board[i] == col){
                return false;
            }
            if (Math.abs(i - row) == Math.abs(board[i] - col)){
                return false;
            }
        }
        return true;
    }
}