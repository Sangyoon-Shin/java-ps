package SWEA.D2_D3;

import java.io.*;
import java.util.*;

public class SWEA1240 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<String, Integer> map = new HashMap<>();
        map.put("0001101", 0);
        map.put("0011001", 1);
        map.put("0010011", 2);
        map.put("0111101", 3);
        map.put("0100011", 4);
        map.put("0110001", 5);
        map.put("0101111", 6);
        map.put("0111011", 7);
        map.put("0110111", 8);
        map.put("0001011", 9);

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] matrix = new int[n][m];

            for (int i = 0; i < n; i++){
                String cur = br.readLine();
                for (int j = 0; j < m; j++){
                    matrix[i][j] = cur.charAt(j) - '0';
                }
            }

            int r = 0, c = 0;
            boolean find = false;
            for (int i = 0; i < n; i++){
                if (find){
                    break;
                }
                for (int j = m - 1; j >= 0; j--){
                    if (matrix[i][j] == 1){
                        r = i;
                        c = j;
                        find = true;
                        break;
                    }
                }
            }

            int[] bit = new int[56];
            int start = 55;
            for (int i = c; i > c - 56; i--){
                bit[start] = matrix[r][i];
                start--;
            }

            int[] cypher = new int[8];

            for (int i = 0; i < 50; i += 7){
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 7; j++){
                    sb.append(bit[i + j]);
                }
                cypher[i / 7] = map.get(sb.toString());
            }

            int oddsum = 0;
            int evensum = 0;
            int sum = 0;
            for (int i = 0; i < 8; i++){
                if (i % 2 == 0){
                    oddsum += cypher[i] * 3;
                } else {
                    evensum += cypher[i];
                }
                sum += cypher[i];
            }
            int total = oddsum + evensum;
            if (total % 10 == 0){
                System.out.println("#" + tc + " " + sum);
            } else {
                System.out.println("#" + tc + " " + 0);
            }
        }

    }
}
