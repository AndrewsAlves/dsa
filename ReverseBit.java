public class ReverseBit {
    public static void main(String[] args) {
        System.out.println(reverseBits(-3));
    }

    public static int reverseBits(int n) {
        char[] decimal = Integer.toBinaryString(n).toCharArray();
        String reverseDecimal = "";
        for (int i = 0; i < decimal.length; i++) {
            System.out.println(decimal[i]);
            reverseDecimal = decimal[i] + "" + reverseDecimal;
        }
        System.out.println(reverseDecimal);
        System.out.println(reverseDecimal);
        return Long.parseInt(reverseDecimal, 2);
    }
}
