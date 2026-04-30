package SWEA.D2_D3;

import java.io.*;

public class SWEA2007 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++){
            String s = br.readLine();

            for (int j = 1; j <= 15; j++){
                String front = s.substring(0, j);
                String back = s.substring(j, 2 * j);
                if (front.equals(back)){
                    System.out.println("#" + i + " " + front.length());
                    break;
                }
            }
        }
    }
}
