package StackQueueDeque;

import java.io.*;

public class BOJ9093_string {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            // 문제의 핵심은 하나의 문자열을 공백 기준으로 쪼개서 각각의 문자열로 나누는거.
            String s = br.readLine(); // 여기서 한 문장을 입력받고
            String[] split = s.split(" "); // 공백을 기준으로 쪼개서 그걸 String 배열에 담아
            StringBuilder result = new StringBuilder(); // 한 번에 출력하기 위한 StringBuilder 만들고
            for (int j = 0; j < split.length; j++){ // split은 배열이니까 size를 알려면 length
                StringBuilder cur = new StringBuilder(split[j]); // 거꾸로 뒤집기 위해 cur 생성
                cur.reverse(); // split[j].reverse(); 처럼 바로 사용이 안되네
                // split[j]는 String 타입인데, 여기에는 reverse() 메서드가 없음.
                result.append(cur).append(' '); // 뒤집은 cur에 공백 추가해서 res에 넣고
            }
            System.out.println(result); // result.toString()이랑 result로 출력하는거랑 뭐가 다르지?
        }
    }
}
