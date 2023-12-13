package completed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramSL2 {
    public static void main(String[] args) {
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        printAnagram(groupedAnagrams(input));
    }
    
    public static List<List<String>> groupedAnagrams(String[] input) {
        Map<String, List<String>> hashMap = new HashMap<>();

        for (String string2 : input) {
            char[] charS = string2.toCharArray();
            String baseString = new String(charS);
            Arrays.sort(charS);
            String string = new String(charS);

            if (!hashMap.containsKey(string)) {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(baseString);
                hashMap.put(string, anagrams);
            } else {
                hashMap.get(string).add(baseString);
            }
        }

        return new ArrayList<List<String>>(hashMap.values());
    }

    public static void printAnagram(List<List<String>> anagraList) {
        for (int i = 0; i < anagraList.size() ; i++) {
            for (int j = 0; j < anagraList.get(i).size() ; j++) {
                System.out.println(anagraList.get(i).get(j));
            }
            System.out.println(" ");
        }
    }
}
