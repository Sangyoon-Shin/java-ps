package CodePlus203;

import java.io.*;
import java.util.*;

public class BOJ11656 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        List<String> arr = new ArrayList<>();

        for (int i = 0; i < s.length(); i++){
            arr.add(s.substring(i, s.length()));
        }
        Collections.sort(arr);
        for (int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i));
        }
    }
}
