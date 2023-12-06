import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] input = {"ddddddddddg","dgggggggggg"};
        List<String> inputList = new ArrayList<>();
        List<List<String>> listAnagrams = new ArrayList<>();

        for (int i = 0; i < input.length ; i++) {
            inputList.add(input[i]);
        }

        for (int i = 0; i<inputList.size() ; i++) {

            String check = inputList.get(i);
            List<String> list = new ArrayList<>();

            for (int j = 0; j < inputList.size(); j++) {
                if (isAnagram(check, inputList.get(j))) {
                    list.add(inputList.get(j));
                    inputList.remove(j);
                    j--;
                }
            }

            i--;

            listAnagrams.add(list);
        }

        printAnagram(listAnagrams);
    }

    public static void printAnagram(List<List<String>> anagraList) {
        for (int i = 0; i < anagraList.size() ; i++) {
            for (int j = 0; j < anagraList.get(i).size() ; j++) {
                System.out.println(anagraList.get(i).get(j));
            }
            System.out.println(" ");
        }
    }

    public static boolean isAnagram(String a, String b) {

        if(a.length() != b.length()) return false;

        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        HashMap<Character,List<Character>> hashA = charArrtoHashMap(charA);
        HashMap<Character,List<Character>> hashB = charArrtoHashMap(charB);

        for(char key : hashA.keySet()) {
            if (hashB.containsKey(key)) {
                int i = hashA.get(key).size();  
                int j = hashB.get(key).size();
                if (i != j){
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public static HashMap<Character, List<Character>> charArrtoHashMap(char[] charArr) {
        HashMap<Character,List<Character>> hashMap = new HashMap<>();
        for(int i = 0; i < charArr.length ; i++) {
            if (hashMap.containsKey(charArr[i])) {
                List<Character> list = hashMap.get(charArr[i]);
                list.add(charArr[i]);
            } else {
                List<Character> list = new ArrayList<>();
                list.add(charArr[i]);
                hashMap.put(charArr[i], list);
            }
        }
        return hashMap;
    }
}
