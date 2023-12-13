package completed;

public class ContainerMostWater {
    public static void main(String[] args) {
        int[] height = {1,1};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        //List<Integer> maxWaterZone = new ArrayList<>();

        int left=0;
        int right = height.length-1;
        int hi,max=0, area = 0;
        while (left != right) {
            hi = Math.min(height[left], height[right]);
            area = hi * Math.abs((left + 1) - (right+1));
            if (area > max) max = area;
            //maxWaterZone.add(area);
            if (height[left] < height[right]) left++;
            else right--;
        }

        //maxWaterZone.sort(Comparator.reverseOrder());

        return max;
    }
}
