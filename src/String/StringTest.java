package String;

import java.io.*;
import java.util.*;

public class StringTest {
    public static void main(String[] args) {

        char smallA = 'a';
        char bigA = 'A';
        String s = "Hello, I am SangYoon";
        System.out.println(Character.toUpperCase(smallA)); // 소문자를 대문자로
        System.out.println(Character.toLowerCase(bigA)); // 대문자를 소문자로
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());

        String s2 = "Hello, I am SangYoon";
        System.out.println(s == s2);
        System.out.println(s.equals(s2));

        System.out.println(s.indexOf('S'));
        System.out.println(s.indexOf("SangYoon"));
        System.out.println(s.indexOf('a'));

        String newS = s.replace('a', 'b');
        System.out.println(newS);

        System.out.println(s.substring(0, 5));

        String testString = "abcde";
        int len = testString.length();

        for (int i = 0; i < len; i++){
            for (int j = i; j <= len; j++){
                System.out.println(testString.substring(i, j));
            }
        }

        int L = 2;
        for (int i = 0; i + L <= len; i++){
            System.out.println(s.substring(i, i + L));
        }

        StringBuilder sb = new StringBuilder();
        sb.append("1").append("2");
        System.out.println(sb);
        sb.setLength(0);
        System.out.println(sb);

        int n = 10;
        System.out.println(Integer.toBinaryString(n));

        String words = "abcdefgh";

        // 이건 배열로 변환하고 값 뽑는거고
        char[] word = words.toCharArray();
        for (char c : word){
            System.out.print(c + " ");
        }

        // 굳이 새 배열로 안 만들고 바로 for 문에서도 가능
        for (char c : words.toCharArray()){
            System.out.print(c + " ");
        }

        System.out.println();
        // 문자열 회전시키기
        s = "abcde";
        n = s.length();

        for (int i = 1; i < n; i++){
            String rotated = s.substring(n - i) + s.substring(0, n - i);
            System.out.println(rotated);
            // 오른쪽으로 i칸 이동의 의미를 알자. => 맨 뒤에 i칸을 앞에 붙이겠다.
            // i는 1일 때, n - i => 5 - 1 = 4니끼, idx 4부터 끝까지 잘라. 그러고 뒤에 0부터 3까지를 이어 붙인다.
        }

        System.out.println();
        s = "abcde";
        // 위의 코드를 응용하면 왼쪽으로 돌리기도 가능하지. => 왼쪽? 맨 왼쪽걸 뒤에 붙여야지
        for (int i = 1; i < n; i++){
            String rotated = s.substring(i) + s.substring(0, i);
            System.out.println(rotated);
        }

    }
}
