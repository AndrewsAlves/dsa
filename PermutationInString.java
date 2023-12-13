import java.util.Arrays;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        char[] perCheckString = s1.toCharArray();
        char[] stringArr = s2.toCharArray();

        Arrays.sort(perCheckString);

        int l = 0,r = perCheckString.length-1;
        while (r < stringArr.length) {
            char[] subString = Arrays.copyOfRange(stringArr, l, r+1);
            Arrays.sort(subString);
            if (Arrays.equals(subString, perCheckString)) return true;
            l++;
            r++;
        }

        return false;
    }
}