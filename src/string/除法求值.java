package string;

import util.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/evaluate-division/
 */
public class 除法求值 {

    private List<List<String>> equations;

    private double[] values;

    /**
     *
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        this.equations = equations;
        this.values = values;
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            result[i] = dfs(new boolean[equations.size()], queries.get(i).get(0), queries.get(i).get(1));
        }
        return result;
    }

    /**
     * dfs遍历
     * 找出以head为头，tail为结尾的链表链路
     *
     * @param visited
     * @param head
     * @param tail
     * @return
     */
    public double dfs(boolean[] visited, String head, String tail) {
        double result = -1;
        for (int i = 0; i < equations.size(); i++) {
            if (visited[i]) continue;/*当前节点已经访问过，直接跳过当前节点*/
            List<String> equation = equations.get(i);
            if (equation.get(0).equals(head)) {
                visited[i] = true;
                if (head.equals(tail)) return 1;
                if (equation.get(1).equals(tail)) return values[i];
                double dfsRes = dfs(visited, equation.get(1), tail);
                if (dfsRes == -1) {
                    visited[i] = false;
                } else {
                    return dfsRes * values[i];
                }
            } else if (equation.get(1).equals(head)) {
                visited[i] = true;
                if (head.equals(tail)) return 1;
                if (equation.get(0).equals(tail)) return 1 / values[i];
                double dfsRes = dfs(visited, equation.get(0), tail);
                if (dfsRes == -1) {
                    visited[i] = false;
                } else {
                    return dfsRes * 1 / values[i];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        /**
         * [["x1","x2"],["x2","x3"],["x1","x4"],["x2","x5"]]
         * [3.0,0.5,3.4,5.6]
         * [["x2","x4"],["x1","x5"],["x1","x3"],["x5","x5"],["x5","x1"],["x3","x4"],["x4","x3"],["x6","x6"],["x0","x0"]]
         */
        List<List<String>> equations = Arrays.asList(
                Arrays.asList("x1", "x2"),
                Arrays.asList("x2", "x3"),
                Arrays.asList("x1", "x4")
        );
        double[] values = new double[]{3, 4, 4};
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("x2", "x4")
        );
        double[] result = new 除法求值().calcEquation(equations, values, queries);
        PrintUtil.printArray(result);
    }
}
