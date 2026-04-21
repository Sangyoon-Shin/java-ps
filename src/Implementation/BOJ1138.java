package Implementation;

import java.io.*;
import java.util.*;

public class BOJ1138 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] order = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            order[i] = Integer.parseInt(st.nextToken());
        }

        int[] res = new int[n];

        for (int i = 0; i < n; i++){
            int cnt = 0;
            for (int j = 0; j < n; j++){
                if (cnt == order[i] && res[j] == 0){
                    res[j] = i + 1;
                    break;
                }
                if (res[j] == 0){
                    cnt++;
                }
            }
        }
        for (int i = 0; i < n; i++){
            System.out.print(res[i] + " ");
        }
    }
}
