public class ClimbingStairs {
    
    public static void main(String[] args) {
        int n = 44;
        int[] noOfWays = {0};
        //generateWays(n, noOfWays, 0);
        //System.out.println(noOfWays[0]);

        int prePrev = 0, pre = 1, copy = 0;
        for (int i = 1; i <= n ; i++) {
            copy = pre;
            pre = pre + prePrev;
            prePrev = copy;
        }

        System.out.println(pre);

    }

    public static void generateWays(int n,int[] noOfWays, int stepsClimbed) {
        if (stepsClimbed > n) return;
        if (stepsClimbed == n) {
            noOfWays[0]++;
            return;
        }
        generateWays(n, noOfWays, stepsClimbed + 1);

        generateWays(n, noOfWays, stepsClimbed + 2);
    }


 }
