import java.io.*;
import java.util.*;

public class Test{
    static ArrayList<String> d = new ArrayList<>();
    static String str;
    public static void main(String[] args) {

        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
        int[] dest = Arrays.copyOfRange(arr, 3, arr.length);

        for (int i : dest){
            System.out.print(i + " ");
        }
    }
}