package Implementation;

import java.io.*;
import java.util.*;

public class BOJ3613 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();

        boolean isUpper = false; // 대문자 존재 여부
        boolean isUnderBar = false; // 언더바 존재 여부
        boolean prevUnder = false;
        boolean nextLarge = false;
        // 대문자 + 언더바 조합이 나오면 에러
        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);

            if (cur == '_'){
                if (i == s.length() - 1 || i == 0 || prevUnder){
                    System.out.println("Error!");
                    return;
                }
                isUnderBar = true;
                nextLarge = true;
                prevUnder = true;
                if (isUpper && isUnderBar){
                    System.out.println("Error!");
                    return;
                }
            }
            if (cur >= 'A' && cur <= 'Z'){
                isUpper = true;
                prevUnder = false;
                if (isUpper && isUnderBar){
                    System.out.println("Error!");
                    return;
                }
                int x = cur + 32;
                if (i == 0){
                    System.out.println("Error!");
                    break;
                } else {
                    sb.append('_').append((char)x);
                }
            } else if (cur >= 'a' && cur <= 'z'){
                prevUnder = false;
                if (nextLarge){
                    int x = cur - 32;
                    sb.append((char)x);
                    nextLarge = false;
                } else {
                    sb.append(cur);
                }
            }
        }
        System.out.println(sb);
    }
}
