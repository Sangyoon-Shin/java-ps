package Sort;

import java.io.*;
import java.util.*;

public class sortTest {
    public static void main(String[] args) throws IOException{

        int[] arr = {9, 10, 1, 3, 2, 6, 4, 5, 8, 7};
        ArrayList<Integer> arrlist = new ArrayList<>();

        for (int i = 10; i > 0; i--){
            arrlist.add(i);
        }

        Arrays.sort(arr);
        Collections.sort(arrlist);

        System.out.print("정렬 후 정적 배열: ");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.print("정렬 후 list 컬렉션: ");
        for (int i = 0; i < arrlist.size(); i++){
            System.out.print(arrlist.get(i) + " ");
        }
        System.out.println();

        // ArrayList 역순 정렬은 처음부터 역순 정렬하거나 오름차순 되어있던 걸 reverse 해주는 방법이 있음
        // Collections.sort(arrlist, Collections.reverseOrder()); // 이게 처음부터 역순 정렬하는 코드
        Collections.reverse(arrlist); // 얘가 오름차순 되어있던걸 뒤집어서 내림차순으로 바꿔주는
        System.out.print("역순 정렬 후 list 컬렉션: ");
        for (int i = 0; i < arrlist.size(); i++){
            System.out.print(arrlist.get(i) + " ");
        }
        System.out.println();

        // int[] 배열은 오름차순 정렬 해둔다음에 뒤집는게 가장 일반적
        for (int l = 0, r = arr.length - 1; l < r; l++, r--){
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
        }
        System.out.print("역순 정렬 후 정적 배열: ");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }
}
