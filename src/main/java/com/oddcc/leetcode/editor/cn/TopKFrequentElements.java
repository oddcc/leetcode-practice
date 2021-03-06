// 347

package com.oddcc.leetcode.editor.cn;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1}, 1)));
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 要求时间复杂度至少是O(NlogN)
        // 思路1，利用哈希表存元素数量，利用容量为k的最小堆来取第k大的数，遍历的同时，不停的入堆，最后再从堆中弹出第k个元素，就是答案
        // 思路2，代码优化
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> countMap = new HashMap<>();
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(countMap::get));
            for (int i : nums) {
                if (countMap.containsKey(i)) {
                    countMap.put(i, countMap.get(i) + 1);
                }
                else {
                    countMap.put(i, 1);
                }
            }

            for (int i : countMap.keySet()) {
                if (minHeap.size() < k) {
                    System.out.println("add " + i);
                    minHeap.add(i);
                }
                else {
                    if (countMap.get(i) < countMap.get(minHeap.peek())) continue;
                    System.out.println("add " + i);
                    minHeap.add(i);
                    System.out.println("remove " + minHeap.remove());
                }
            }

            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                int n = minHeap.remove();
                System.out.println("retrieve " + n);
                ans[i] = n;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}