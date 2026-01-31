package StackQueueDeque;

import java.io.*;
import java.util.*;

public class BOJ17299 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> numcnt = new HashMap<Integer, Integer>();

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int[] times = new int[n];
        int[] res = new int[n];
        ArrayDeque<Integer> cntStack = new ArrayDeque<>();
        ArrayDeque<Integer> idxStack = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            num[i] = Integer.parseInt(st.nextToken());
            numcnt.put(num[i], numcnt.getOrDefault(num[i], 0) + 1);
        }

        for (int i = 0; i < n; i++){
            times[i] = numcnt.get(num[i]);
        }

        for (int i = 0; i < n; i++){
            res[i] = -1;
        }

        for (int i = 0; i < n; i++){
            if (idxStack.isEmpty()){
                cntStack.addLast(times[i]);
                idxStack.addLast(i);
            } else {
                if (cntStack.peekLast() > times[i]){
                    while (!idxStack.isEmpty() && times[i] < cntStack.peekLast()){
                        res[i] = num[idxStack.removeLast()];
                        cntStack.removeLast();
                    }
                    cntStack.addLast(times[i]);
                    idxStack.addLast(i);
                } else {
                    cntStack.addLast(times[i]);
                    idxStack.addLast(i);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            sb.append(res[i] + " ");
        }
        System.out.println(sb);
    }
}
