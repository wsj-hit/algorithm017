import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 */
public class TwoSum {


    //返回下标
    public int[] twoSum(int[] nums, int target) {
        // map k-target v 值得下标
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            Integer index = map.get(nums[i]);
            if ( index != null) {
                return new int[]{index,i};
            } else {
                map.put(target - nums[i],i);
            }
        }
        return new int[]{};
    }
}
