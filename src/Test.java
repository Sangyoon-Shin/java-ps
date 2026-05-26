import java.io.*;
import java.util.*;

public class Test {
    static int n, k;
    static int res;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = new int[] {-1, 1, 0, 0};
    static int[] dc = new int[] {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s = br.readLine();
        int res = myAtoi(s);
        System.out.println(res);


    }
    public static int myAtoi(String s) {
        s = s.trim();

        StringBuilder sb = new StringBuilder();

        boolean isFirstZero = true;
        for (int i = 0; i < s.length(); i++){
            if (i == 0 && s.charAt(i) == '-'){
                sb.append(s.charAt(i));
                continue;
            } else if (i == 0 && s.charAt(i) == '+'){
                continue;
            }
            if (isFirstZero && s.charAt(i) == '0'){
                continue;
            } else if (!isFirstZero && s.charAt(i) == '0'){
                sb.append(s.charAt(i));
                continue;
            }
            if (s.charAt(i) >= '1' && s.charAt(i) <= '9'){
                isFirstZero = false;
                sb.append(s.charAt(i));
            } else {
                break;
            }
        }

        if (sb.length() == 0){
            return 0;
        }
        if (sb.length() > 12){
            String cur = sb.toString();
            if (cur.charAt(0) == '-'){
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        } else {
            long cur = Long.parseLong(sb.toString());
            if (cur > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            } else if (cur < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            } else {
                return (int)cur;
            }

        }

    }
}