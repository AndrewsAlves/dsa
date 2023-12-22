import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;;

public class DecodeWaysDP {
    public static void main(String[] args) {
        String s = "06"; 
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        List<List<String>> containsList = new ArrayList<>();

        for (int i = s.length()-1; i >= 0 ; i--) {
            int ways = 0;
            ways = generateWays2(s.toCharArray(),containsList,hashmap,new ArrayList<>(),1,i);
            ways = ways + generateWays2(s.toCharArray(),containsList,hashmap,new ArrayList<>(),2,i);
            //System.out.println(i + " " + ways);
            hashmap.put(i, ways);
        }
        System.out.println(hashmap.get(0));
    }

    public static int generateWays2(char[] chars,List<List<String>> containsList, HashMap<Integer, Integer> hashmap, List<String> charSubList,int choice, int index) {

        if (index >= chars.length) {
            if (containsCombination(containsList, charSubList)) return 0;
            containsList.add(charSubList);
            //printList(charSubList);
            return 1;
        }

        List<String> charSubListCopy = new ArrayList<>(charSubList);

        String code = "";
        if (choice == 1) code = String.valueOf(chars[index]);
        else if (choice == 2 && index+1 < chars.length && Integer.parseInt(String.valueOf(chars[index])) != 0) code = String.valueOf(chars[index]) + String.valueOf(chars[index+1]);
        else return 0;

        if (isValidCode(code) == 1) {
            charSubListCopy.add(code);
        } else {
            return 0;
        }

        if (choice == 1) index = index+1;
        if (choice == 2) index = index+2;
    
        if (hashmap.containsKey(index)) return hashmap.get(index);

        int ways = 0;
        ways = generateWays2(chars,containsList, hashmap, charSubListCopy,1,index);
        ways = ways + generateWays2(chars,containsList, hashmap, charSubListCopy,2,index);
        return ways;
    }

    public static void printList(List<String> charSubList) {
        for (String s : charSubList) {
            System.out.print(s + " ");
        }
        System.out.println("");
    }

    public static boolean containsCombination(List<List<String>> containsList, List<String> list) {
        for (List<String> lists : containsList) {
            if (lists.equals(list)) return true;
        }
        return false;
    }
    
    public static int isValidCode(String code) {
        if (Integer.parseInt(code) > 26 || Integer.parseInt(code) <= 0) return 0;
        else return 1;
    }



    public static int numDecodings(String s ) {
        char[] ch = s.toCharArray();
        HashMap<Integer, Integer> noOfWays = new HashMap<>();
        for (int i = ch.length-1; i >=0; i--) {
            generateWays(ch, i, noOfWays);
        }

        int max = 1;
        for (int i = 0; i < ch.length; i++) {
             max = max * noOfWays.get(i);
        }

        return max;
    }

    public static void generateWays(char[] ch, int index, HashMap<Integer, Integer> noOfWays) {
        if (index >= ch.length) return;

        int ways = 0;
        ways = noOf(String.valueOf(ch[index]), noOfWays);
        if (index+1 < ch.length && ways != 0) {
            ways = ways + noOf(String.valueOf(ch[index]) + String.valueOf(ch[index+1]), noOfWays);
        }
        noOfWays.put(index, ways);

        if (!noOfWays.containsKey(index+1)) {
            generateWays(ch, index+1, noOfWays);
        }
    }

    public static int noOf(String code, HashMap<Integer, Integer> noOfWays) {
        if (Integer.parseInt(code) > 26 || Integer.parseInt(code) <= 0) return 0;
        else return 1;
    }
}
