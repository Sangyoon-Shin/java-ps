package CodePlus301;

import java.io.*;
import java.util.*;

public class BOJ17087 {
    static int[] posGap;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        posGap = new int[n];

        String[] s = br.readLine().split(" ");
        // 현재 지점에서 모든 거리 차이를 알아두면 그 차이들의 gcd가 한 번에 이동할 수 있는 최대 단위
        for (int i = 0; i < s.length; i++){
            int pos = Integer.parseInt(s[i]);
            if (pos >= start){
                posGap[i] = pos - start;
            } else {
                posGap[i] = start - pos;
            }
        }

        int res = 0;
        int cur = posGap[0];
        if (n == 1){
            System.out.println(cur);
        } else {
            for (int i = 1; i < posGap.length; i++){
                res = gcd(cur, posGap[i]);
                cur = res;
            }
            System.out.println(res);
        }
    }
    static private int gcd(int a, int b){
        if (b == 0){
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
