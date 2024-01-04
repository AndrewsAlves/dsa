package completed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CoinChangeDP {
    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        int amount = 6249;
        int[] minSet = {-1};

        Arrays.sort(coins);
        if (coins[0] > amount) minSet[0] = -1;
        if (amount == 0) minSet[0] = 0;
        
        HashMap<Integer, Integer> HashMap = new HashMap<>();
        for (int i = coins.length-1; i >= 0; i--) {
            if (coins[i] == amount) {
                minSet[0] = 1; 
                break;
            }
            if (coins[i] > amount) continue;
            generateDenominations(coins, i, HashMap, minSet, 0, amount, 0);
        }

        System.out.println(minSet[0]);
    }

    public static int generateDenominations(int[] coins, int index, HashMap<Integer, Integer> HashMap, int[] minSet, int sum, int amount, int coinsCount) {
        coinsCount++;
        sum = sum + coins[index];

        if (sum == amount) {
            if (minSet[0] == -1 || minSet[0] > coinsCount) minSet[0] = coinsCount;
            return coinsCount;
        }

        int diff = amount - sum;

        if (HashMap.containsKey(diff)) {
            if (HashMap.get(diff) == -1) return -1;
            coinsCount = coinsCount+HashMap.get(diff);
            if (minSet[0] == -1 || minSet[0] > coinsCount) minSet[0] = coinsCount;
            return coinsCount;
        }

        int noOfCoins = -1;
        for (int i = coins.length-1; i >= 0; i--) {
            if (coins[i] > amount) continue;
            if (sum+coins[i] > amount) continue;
            int coinsTotal = generateDenominations(coins, i, HashMap, minSet, sum, amount, coinsCount);
            if (noOfCoins == -1 ) noOfCoins = coinsTotal;
            if (coinsTotal != -1 && noOfCoins > coinsTotal) noOfCoins = coinsTotal;
        }

        if (noOfCoins != -1)HashMap.put(diff, noOfCoins-coinsCount);
        else HashMap.put(diff, noOfCoins);
        return noOfCoins;
    }
}
