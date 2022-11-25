package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.cn/problems/merge-intervals/
 */
public class 合并区间 {

    public int[][] merge(int[][] intervals) {
        /*先对数组的左端点进行排序*/
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        /*待合并的数组merge*/
        int[] merge = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (merge[1] < current[0]) {/*不需要合并*/
                res.add(merge);
                merge = current;
            } else {/*需要合并*/
                merge = mergeSingleInterval(merge, current);
            }
        }
        res.add(merge);
        return res.toArray(new int[res.size()][2]);
    }

    public int[] mergeSingleInterval(int[] left, int[] right) {
        int leftNum = Math.min(left[0], right[0]);
        int rightNum = Math.max(left[1], right[1]);
        return new int[]{leftNum, rightNum};
    }
}
