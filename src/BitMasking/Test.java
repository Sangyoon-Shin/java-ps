package BitMasking;

public class Test {
    public static void main(String[] args) {
        int n = 7;
        String s = Integer.toBinaryString(n);
        System.out.println(s);
        System.out.println(Integer.bitCount(n));
    }
}
