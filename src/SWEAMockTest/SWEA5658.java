package SWEAMockTest;

import java.io.*;
import java.util.*;

public class SWEA5658 {
    static int t, n, k;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n은 숫자 개수. n = 12면, 각 변에 3개씩. n = 4면, 각 변에 1개씩. 일단 n번 돌려야 하는거고, 동시에 n / 4개 단위로 쪼개서 값을 읽어야 함

        t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            String s = br.readLine();
            ArrayDeque<String> circle = new ArrayDeque<>(); // 원형큐로 만들어서 돌릴거
            for (int i = 0; i < s.length(); i++){
                circle.addLast(String.valueOf(s.charAt(i)));
            }

            Set<Integer> set = new HashSet<>(); // 만들어진 숫자를 저장할 set. 중복 없어야됨.

            for (int i = 0; i < n; i++){
                ArrayList<String> list = new ArrayList<>(circle);
                for (int j = 0; j < n; j += n / 4){
                    String cur = "";
                    for (int k = j; k < j + (n / 4); k++){
                        cur += list.get(k);
                    }
                    set.add(Integer.parseInt(cur, 16));
                }
                circle.addFirst(circle.removeLast()); // 회전시켜주고
            }

            ArrayList<Integer> numbers = new ArrayList<>(set);
            Collections.sort(numbers, Collections.reverseOrder());
            System.out.println("#" + tc + " " + numbers.get(k - 1));
        }
    }
}
