package HashMap;

import java.io.*;
import java.util.*;

public class BOJ7785 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map =  new HashMap<>();
        for (int i = 0; i < n; i++){
            String[] s =  br.readLine().split(" ");
            if (s[1].equals("enter")){
                map.put(s[0], 1);
            } else {
                map.remove(s[0]);
            }
        }

        ArrayList<String> arr = new ArrayList<>(map.keySet());
        Collections.sort(arr, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for (String name : arr){
            sb.append(name).append("\n");
        }
        System.out.println(sb);

    }
}
