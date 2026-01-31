package EuclideanAlgorithm_GCD_LCM;

import java.io.*;
import java.util.*;

public class gcd_lcm {
    public static void main(String[] args) {

        int a = 24;
        int b = 34;
        int resIter = gcdIter(a, b);
        int resRecursive = gcdRecursive(a, b);
        System.out.println(resIter);
        System.out.println(resRecursive);
        int lcm = ((a * b) / resIter);
        System.out.println(lcm);
    }
    // gcd(a, b) = gcd(b, a % b)
    static private int gcdIter(int a, int b){
        while (b != 0){
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
    static private int gcdRecursive(int a, int b){
        if (b == 0){
            return a;
        } else {
            return gcdRecursive(b, a % b);
        }
    }
}
