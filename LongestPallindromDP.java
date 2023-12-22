import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestPallindromDP {
    public static void main(String[] args) {
        String s = "cbbd";
        char[] arrS = s.toCharArray();
        int noOfPali = s.length();
        for (int i = 0; i < arrS.length ; i++) {
            String charStr = "";
            for (int j = i; j < arrS.length;j++) {
                charStr = charStr + arrS[j];
                if (charStr.length() == 1) continue;
                if (charStr.charAt(0) == charStr.charAt(charStr.length()-1)) {
                    if (isPalindrom(charStr)) noOfPali++;
                }
            }
        }

        System.out.println(noOfPali);
    }

    public static boolean isPalindrom(String s) {
        char[] a = s.toCharArray();
        int l = 0, r = a.length-1;
        while (l <= r) {
            if (a[l] != a[r]) return false;
            l++;
            r--;
        }
        return true;
    }
}
