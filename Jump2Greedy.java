public class Jump2Greedy {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int lastIndex = nums.length-1;
        for (int i = nums.length-1; i >= 0; i--) {
            if (i == nums.length-1) {
                nums[i] = 0;
                continue;
            } 
            if (i == nums.length-2 && nums[i] != 0) {
                nums[i] = 1;
                continue;
            } 

            if (nums[i] == 0) {
                continue;
            }

            int stepsNeeded = lastIndex - i;
            if (nums[i] >= stepsNeeded) {
                nums[i] = 1;
                continue;
            } else {
                int steps = nums[i];
                int stepsTaken = 0;
                int minJum = -1;
                nums[i] = 1;
                while (stepsTaken < steps) {
                    stepsTaken++;
                    if (nums[i+stepsTaken] == 0) continue;
                    if (minJum == -1) {
                        minJum = nums[i+stepsTaken];
                        continue;
                    }
                    minJum = Math.min(nums[i+stepsTaken], minJum);
                }
                nums[i] += minJum;
            }
        }
        return nums[0];
    }

    
}
