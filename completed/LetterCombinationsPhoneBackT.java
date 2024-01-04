package completed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class LetterCombinationsPhoneBackT {

    public static void main(String[] args) {
        String digits = "23";
        String[] mappings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        char[] arrDigits = digits.toCharArray();
        generateCombination(arrDigits, 0, mappings, result, new char[arrDigits.length]);
    }

    public static void generateCombination(char[] digits, int index, String[] mappings, List<String> result, char[] subString) {
        char[] arrDigits = mappings[Character.getNumericValue((digits[index]))].toCharArray();
        for (int i = 0; i < arrDigits.length; i++) {
            char[] subStringCopy = subString.clone();
            subStringCopy[index] = arrDigits[i];
            if (index == digits.length-1) {
                result.add(String.copyValueOf(subStringCopy));
                continue;
            } 
            generateCombination(digits, index+1, mappings, result, subStringCopy);
        }

    }
}