package completed;
import java.util.HashMap;

public class LongestSubString {

    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {

        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;

        char[] charString = s.toCharArray();
        HashMap<Character, Character> hashMap = new HashMap<>();
        int noOfCharacters = 0;
        int maxCount = 0;

        int i = 0;
        while ( i < charString.length) {
            if (!hashMap.containsKey(charString[i])) {
                hashMap.put(charString[i], charString[i]);
                noOfCharacters++;
                i++;
            } else {
                if (noOfCharacters > maxCount ) maxCount = noOfCharacters;
                noOfCharacters = 0;
                hashMap.clear();
                for (int j = i-1; j >= 0; j--) {
                    if (charString[j] == charString[i]) {
                        i = j+1;
                        break;
                    }
                }
            }

        }

        if (noOfCharacters > maxCount ) maxCount = noOfCharacters;
        return maxCount;

    }
}