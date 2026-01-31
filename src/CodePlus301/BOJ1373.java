package CodePlus301;

import java.io.*;
import java.util.*;

public class BOJ1373 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        if (s.length() == 1 && s.charAt(0) == '0'){
            System.out.println(0);
            return;
        }

        int start = 1;
        int sum = 0;
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--){
            sum += start * Integer.parseInt(String.valueOf(s.charAt(i)));
            start *= 2;
            cnt += 1;
            if (cnt == 3){
                sb.append(sum);
                sum = 0;
                cnt = 0;
                start = 1;
            }
        }
        if (sum == 0){
            sb.reverse();
            System.out.println(sb);
        } else {
            sb.append(sum);
            sb.reverse();
            System.out.println(sb);
        }
    }
}
