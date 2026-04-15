package Implementation;

import java.util.*;
import java.io.*;

public class BOJ1680 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int dist = 0, weight = 0;
            for (int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                int xi = Integer.parseInt(st.nextToken());
                int wi = Integer.parseInt(st.nextToken());

                if (weight + wi > w){ // 현재 지점의 쓰레기를 담았을 때 용량 초과하면, 현재 쓰레기 용량 초기화 + 이동거리에 현재 위치의 2배 추가.
                    weight = 0;
                    dist += 2 * xi;
                }
                weight += wi; // 초과하는거만 아니면 일단 그 지점의 쓰레기 실어봐야지
                if (weight == w){ // 초과하진 않지만, 현재 지점해서 더했을 때 딱 같아지는 경우
                    weight = 0;
                    dist += 2 * xi;
                } else if (j == n - 1){ // 마지막 까지 왔다면, 쓰레기장으로 복귀시키기
                    dist += 2 * xi;
                }
            }
            System.out.println(dist);
        }
    }
}
