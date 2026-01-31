package CodePlus300;

import java.io.*;
import java.util.*;

public class BOJ2004 {
    public static void main(String[] args) throws IOException{
        // nCr => n! / r!(n - r)!
        // 그러면 분모에서 각각의 0의 개수를 더하고, 그 값을 분자의 0의 개수에서 뺀다라?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int rFactZeroCnt = 0;
        int nMinusRFactZeroCnt = 0;
        int nFactZeroCnt = 0;
        int ntmp = n;
        int rtmp = r;
        int nrtmp = n - r;

        while (ntmp > 0){
            nFactZeroCnt += ntmp / 5;
            ntmp /= 5;
        }

        while (rtmp > 0){
            rFactZeroCnt += rtmp / 5;
            rtmp /= 5;
        }

        while (nrtmp > 0){
            nMinusRFactZeroCnt += nrtmp / 5;
            nrtmp /= 5;
        }

        int res = nFactZeroCnt - (rFactZeroCnt + nMinusRFactZeroCnt);
        System.out.println(res);

    }
}
