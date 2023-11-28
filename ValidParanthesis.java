

import java.util.HashMap;
import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {
        String input = "(([]))";
        ValidParanthesis vp = new ValidParanthesis();
        boolean result = vp.isValid(input);
        System.out.println(result);
    }

    public boolean isValid(String s) {

        if (s.length() <= 1 || s.length()%2 != 0) {
            return false;
        }

        HashMap<Character, Character> hashBrackets = new HashMap<Character, Character>();
        hashBrackets.put(')', '(');
        hashBrackets.put(']', '[');
        hashBrackets.put('}', '{');

        Stack<Character> cStack = new Stack<Character>();

        char[] charS = s.toCharArray();

        for (int i = 0; i < charS.length ; i++) {
        
            if (hashBrackets.containsValue(charS[i])) {
                cStack.push(charS[i]);
            } else if (hashBrackets.containsKey(charS[i]) && i != 0) {
                if (cStack.isEmpty()) return false;
                char element = cStack.pop();
                if (element != hashBrackets.get(charS[i])) {
                    return false;
                }
            } else {
                return false;
            }
        }

        if(cStack.isEmpty()){
            return true;
        } else {
            return false;
        }   
        
    }
}
