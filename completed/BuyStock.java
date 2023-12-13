package completed;
public class BuyStock {
    public static void main(String[] args) {
        // 7,6,4,3,1
        // 7,3,5,6,1,2,7
        // 9,8,7,3,4,5,2,1
        // 7,1,5,3,6,4
        // 2,1,2,0,1
        // 2,1,2,1,0,1,2
        // 3,3,5,0,0,3,1,4
        int[] prices = {1,4,2};
        int result = maxProfit(prices);
        System.out.println(result);
    }

    public static int maxProfit(int[] prices) {

        if (prices.length <= 1) {
            return 0;
        }
        if (prices.length == 2) {
            if (prices[0] > prices[1] || prices[0] == prices[1]) {
                return 0;
            } else {
                return prices[1] - prices[0];
            }
        }

        int low = 0;
        int high = 0;
        int reward = 0;

        for (int i = 0; i < prices.length - 1; i++) {

            if (i == 0) {
                if (prices[i] < prices[i+1]) {
                    high = prices[i+1];
                    low = prices[i];
                    reward = high - low;
                } else {
                    low = prices[i+1];
                    high = 0;
                    reward = high - low;
                }
                continue;
            }

            if (prices[i] <= low ){
                low = prices[i];
            }

            if (isRewarding(reward, low, prices[i+1])) {
                reward = prices[i+1] - low;
            }   
        }

        if (reward < 0) {
            return 0;
        }
        System.gc();
        return reward;
    }

    public static boolean isRewarding(int reward, int low, int high) {
        int newReward = high - low; 
        if (newReward > reward) {
            return true;
        } else return false;
    }
}
