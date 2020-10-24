package com.oddcc.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicate().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 思路1，记录访问过的数，哈希表
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> cache = new HashSet<>();
            for (int i: nums) {
                if (cache.contains(i)) {
                    return true;
                } else {
                    cache.add(i);
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}