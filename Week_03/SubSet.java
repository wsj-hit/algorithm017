import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 */
public class SubSet {
    /**
     对于集合中的每一个元素 都有加入的可能或者不加入的可能
     */
    public List<List<Integer>> subsets(int[] nums) {
        subs(0,new ArrayList<Integer>(),nums);
        return ret;
    }

    List ret = new ArrayList();

    private void subs(int index,List<Integer> list,int[] nums){
        if(nums == null || index >= nums.length) {
            ret.add(new ArrayList(list));
            return ;
        }
        //不加入
        subs(index+1,list,nums);
        //加入
        list.add(nums[index]);
        subs(index+1,list,nums);
        list.remove(list.size()-1);
    }

}
