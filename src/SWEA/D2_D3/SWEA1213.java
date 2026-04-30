package SWEA.D2_D3;

import java.io.*;

public class SWEA1213 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++){
            int t = Integer.parseInt(br.readLine());
            String find = br.readLine();
            String s = br.readLine();

            int len = find.length();

            int cnt = 0;
            for (int i = 0; i <= s.length() - len; i++){
                if (s.charAt(i) == find.charAt(0)){
                    boolean flag = true;
                    for (int j = i; j < i + len; j++){
                        if (j >= s.length()){
                            break;
                        }
                        if (s.charAt(j) == find.charAt(j - i)){
                            continue;
                        } else {
                            flag = false;
                            break;
                        }
                    }
                    if (flag){
                        cnt++;
                    }
                }
            }
            System.out.println("#" + tc + " " + cnt);
        }
    }
}
