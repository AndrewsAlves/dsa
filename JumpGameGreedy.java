public class JumpGameGreedy {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};

        int lastIndex = nums.length-1;
        for (int i = nums.length-1; i >= 0; i--) {
            if (i == nums.length-1) {
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
                nums[i] = 0;
                while (stepsTaken < steps) {
                    stepsTaken++;
                    if (nums[i+stepsTaken] == 1) {
                        nums[i] = 1;
                        break;
                    }
                }
            }
        }

        if (nums[0] == 1) return true;
        return false;
    }
}
