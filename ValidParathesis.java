import java.util.Stack;

public class ValidParathesis {
    public static void main(String[] args) {
        String s = "(*)";
        
        if (s.charAt(0) ==  ')') return false;
        
        int leftMin = 0, leftMax = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMin++;
                leftMax++;
            } else if(c == '*') {
                leftMin--;
                leftMax++;
            } else {
                leftMin--;
                leftMax--;
            }
            if (leftMax < 0) return false;
            if (leftMin < 0) leftMin = 0;
        }

        if (leftMin == 0 || leftMax == 0)return true;
    

        return false;
    }
}
