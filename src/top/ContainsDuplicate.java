package top;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/contains-duplicate/
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int n : nums){
            if (map.get(n) == null){
                map.put(n,1);
            }else {
                return true;
            }
        }
        return false;
    }
}
