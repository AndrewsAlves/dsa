

/*

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 */


public class ValidPalindrom {

    

    public static void main(String[] args) {
        String input = " ";
        ValidPalindrom vp = new ValidPalindrom();
        boolean result = vp.isPalindrome(input);
        System.out.println(result);
    }

    public boolean isPalindrome(String s) {

        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();

        int i = 0;
        int j = s.length() - 1;

        char[] charS = s.toCharArray();
        for (int k = 0; k < s.length(); k++) {
            if (charS[j] != charS[i]) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

}
