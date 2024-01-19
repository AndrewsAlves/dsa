import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * PartitionLabelsGreedy
 */
public class PartitionLabelsGreedy {

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        char[] sArr = s.toCharArray();

        List<Integer> partitionSizeLst = new ArrayList<>();

        int partStart = 0;
        Set<Character> charSet = new HashSet<>();
        int j  = -1;

        for (int i = 0; i < sArr.length; i++) {

            if (i == j) {
                int len = (j - partStart)+1;
                partitionSizeLst.add(len);
                partStart = i+1;
                j=-1;
                charSet = new HashSet<>();
                continue;
            }

            if (charSet.contains(sArr[i])) continue;
            charSet.add(sArr[i]);
            for (int k = sArr.length-1; k >= i; k--) {
                if (k == j) break;
                if (sArr[k] == sArr[i]) {
                    j = k;
                    break;
                }
            }

            if (j == sArr.length-1) {
                int len = (j - partStart)+1;
                partitionSizeLst.add(len);
                break;
            }

            if (i == j) {
                int len = (j - partStart)+1;
                partitionSizeLst.add(len);
                partStart = i+1;
                j=-1;
                charSet = new HashSet<>();
            }
        }

        for (int n : partitionSizeLst) {
            System.out.println(n);
        }
    }
}