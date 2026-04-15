import java.io.*;
import java.util.*;

public class Test{
    static ArrayList<String> d = new ArrayList<>();
    static String str;
    public static void main(String[] args) {

        str = "AEIOU";
        dfs("");

        for (String v : d){
            System.out.println(v);
        }
        System.out.println(d.size());
    }
    public static void dfs(String s){
        if (s.length() == 5){
            return;
        }
        for (int i = 0; i < 5; i++){
            String newstr = s + str.charAt(i);
            d.add(newstr);
            dfs(newstr);
        }
    }
}