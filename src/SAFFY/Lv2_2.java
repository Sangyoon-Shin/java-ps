package SAFFY;

import java.io.*;
import java.util.*;

public class Lv2_2 {
    static int t, n, m;
    static int[] arr;
    static int[] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            m = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 기존거리 - 새로운 거리의 차가 최대인 걸 잘라야함 -> 그 만큼 많이 단축된다는 거니까
            dist = new int[n]; // 각각 i번째 노드를 끊었을때 차이의 값
            int res = Integer.MAX_VALUE;

            // 맨 첫 요소를 제거하는 경우


        }
    }
    public static int cal(int front, int end){
        if (front < end){
            return end - front;
        } else {
            return m - end + front;
        }
    }
}
