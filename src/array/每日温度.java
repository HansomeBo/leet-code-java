package array;

import util.PrintUtil;

/**
 * https://leetcode.cn/problems/daily-temperatures/
 */
public class 每日温度 {

    /**
     * [73,74,75,71,69,72,76,73]
     * <p>
     * 倒序遍历
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] res = new int[length];
        for (int i = length - 2; i >= 0; i--) {
            if (temperatures[i] < temperatures[i + 1]) {
                res[i] = 1;
            } else {
                /*这个循环里面的 j += res[j] 非常重要*/
                for (int j = i + 1; j < res.length; j += res[j]) {
                    if (temperatures[j] > temperatures[i]){
                        res[i] = j - i;
                        break;
                    }
                    if (res[j] == 0) break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new 每日温度().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        PrintUtil.printArray(res);
    }
}
