package SWEA.D2_D3;

import java.io.*;

public class SWEA1989 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++){
            String s = br.readLine().trim();
            StringBuilder sb = new StringBuilder();

            for (int j = s.length() - 1; j >= 0; j--){
                sb.append(s.charAt(j));
            }
            String cmp = sb.toString();

            int flag;
            if (s.equals(cmp)){
                flag = 1;
            } else {
                flag = 0;
            }
            System.out.println("#" + i + " " + flag);
        }
    }
}
