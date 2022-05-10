package dp.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/pascals-triangle-ii/
 */
public class PascalsTriangleII {

    /**
     * lastRow记住上层的数据，根据上层的数据向下不断迭代
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> lastRow = new ArrayList<Integer>();
        lastRow.add(1);
        for(int i = 0; i < rowIndex; i++){
            List<Integer> curRow = new ArrayList<Integer>();
            for(int j = 0; j < lastRow.size(); j++){
                if(j == 0) curRow.add(1);
                if(j + 1 < lastRow.size()) curRow.add(lastRow.get(j) + lastRow.get(j + 1));
                if(j == lastRow.size() - 1) curRow.add(1);
            }
            lastRow = curRow;
        }
        return lastRow;
    }
    
}
