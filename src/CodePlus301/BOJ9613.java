package CodePlus301;

import java.io.*;
import java.util.*;

public class BOJ9613 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++){
            ArrayList<Integer> num = new ArrayList<>();
            String[] nums = br.readLine().split(" ");
            for (int j = 1; j < nums.length; j++){
                num.add(Integer.parseInt(nums[j]));
            }

            long sum = 0L;
            for (int j = 0; j < num.size() - 1; j++){
                for (int k = j + 1; k < num.size(); k++){
                    sum += gcd(num.get(j), num.get(k));
                }
            }
            System.out.println(sum);
        }
    }

    static private int gcd(int a, int b){
        if (b == 0){
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
