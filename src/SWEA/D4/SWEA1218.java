package SWEA.D4;

import java.io.*;
import java.util.*;

public class SWEA1218 {
    static int len;
    static ArrayDeque<String> st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++){
            len = Integer.parseInt(br.readLine());
            st = new ArrayDeque<>();
            String s = br.readLine();

            for (int i = 0; i < len; i++){
                String cur = String.valueOf(s.charAt(i));
                if (!st.isEmpty()){
                    switch(cur){
                        case ")":
                            if (st.peekFirst().equals("(")){
                                st.removeFirst();
                            } else {
                                st.addFirst(cur);
                            }
                            break;
                        case ">":
                            if (st.peekFirst().equals("<")){
                                st.removeFirst();
                            } else {
                                st.addFirst(cur);
                            }
                            break;
                        case "}":
                            if (st.peekFirst().equals("{")){
                                st.removeFirst();
                            } else {
                                st.addFirst(cur);
                            }
                            break;
                        case "]":
                            if (st.peekFirst().equals("[")){
                                st.removeFirst();
                            } else {
                                st.addFirst(cur);
                            }
                            break;
                        default:
                            st.addFirst(cur);
                    }
                } else {
                    st.addFirst(cur);
                }
            }
            if (st.isEmpty()){
                System.out.println("#" + tc + " " + 1);
            } else {
                System.out.println("#" + tc + " " + 0);
            }
        }
    }
}
