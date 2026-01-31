package CodePlus300;

import java.io.*;
import java.util.*;

public class BOJ1676 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 뒤에 나오는 0의 개수의 의미 => 10이 몇 번 곱해졌냐? 근데 10은 2 * 5로 이루어짐.
        // 그리면 2와 5의 세트가 몇 개 존재하는지가 0의 개수를 정하는데
        // 소인수분해 특성상 작은수가 더 많이 곱해질 수 밖에 없음

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (n > 0){
            cnt = cnt + (n / 5);
            n /= 5;
        }
        System.out.println(cnt);
    }

}
