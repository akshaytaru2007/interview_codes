/**
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class MoveZeroToLeft {

    public void moveZeros() {
        int[] nums = new int[]{0, 1, 0, 3, 12};

        int nonZeroIndex = 0;

        for (int i=0; i< nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }

        System.out.println("nonZeroIndex:" + nonZeroIndex);

        while (nonZeroIndex<nums.length) {
            nums[nonZeroIndex] = 0;
            nonZeroIndex++;
        }

        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }
}
