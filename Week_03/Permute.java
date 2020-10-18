import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */

public class Permute {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();


    public List<List<Integer>> permute(int[] nums) {
        dsf(0 , nums);
        return ans;
    }

    private void dsf(int level ,int[] nums){
        if(level == nums.length) {
            ans.add(new ArrayList(temp));
            return;
        }

        for (int i = 0 ; i < nums.length ; i++) {
            if(!temp.contains(nums[i])) {
                temp.add(nums[i]);
                dsf(level+1, nums);
                temp.remove(temp.size()-1);
            }

        }
    }

}
