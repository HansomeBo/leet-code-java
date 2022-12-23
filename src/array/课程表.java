package array;

import util.PrintUtil;

import java.util.*;

/**
 * https://leetcode.cn/problems/course-schedule/
 * <p>
 * 自顶向下：链表判断有没有环
 * 自下而上：计算入度为零的节点，向上递推
 */
public class 课程表 {

    /**
     * 自顶向下
     * 递归的方式，最后一个测试用例超时
     * TODO 把这个方法改成迭代，因为递归超时了
     */
    static class Solution1 {

        /*记录已经访问过的数组，不重复访问*/
        private boolean[] visited;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (prerequisites == null || prerequisites.length == 0) return true;
            visited = new boolean[prerequisites.length];
            for (int i = 0; i < prerequisites.length; i++) {
                visited[i] = true;
                if (findCircle(prerequisites, prerequisites[i][1], prerequisites[i][0])) return false;
                visited[i] = false;
            }
            return true;
        }

        public boolean findCircle(int[][] prerequisites, int tail, int head) {
            if (tail == head) {
                return true;
            }
            for (int i = 0; i < prerequisites.length; i++) {
                if (visited[i]) continue;
                if (prerequisites[i][0] == tail) {
                    visited[i] = true;
                    if (findCircle(prerequisites, prerequisites[i][1], head)) return true;
                    visited[i] = false;
                }
            }
            return false;
        }
    }


    /**
     * 自底向上遍历
     */
    static class Solution2 {


        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] count = new int[numCourses];/*记录每节课的入度数*/
            Map<Integer, List<Integer>> map = new HashMap<>();/*记录课程的先后映射关系*/
            for (int[] prerequisite : prerequisites) {
                count[prerequisite[0]]++;
                List<Integer> list = map.getOrDefault(prerequisite[1], new ArrayList<>());
                list.add(prerequisite[0]);
                map.put(prerequisite[1], list);
            }
            PrintUtil.printArray(count);
            System.out.println(map);
            Queue<Integer> queue = new LinkedList<>();/*入度为零的节点*/
            for (int i = 0; i < count.length; i++) {
                if (count[i] == 0) queue.offer(i);
            }
            while (!queue.isEmpty()) {
                Integer cur = queue.poll();
                List<Integer> list = map.get(cur); /*以cur为前置的后置节点集合*/
                if (list == null) continue;
                for (Integer i : list) {
                    count[i]--;/*后置节点入度数都减一*/
                    if (count[i] == 0) queue.offer(i);/*当前节点减完后判断当前节点是否入度为零*/
                }
            }
            for (int i = 0; i < count.length; i++) {
                if (count[i] > 0) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().canFinish(3, new int[][]{{1, 0}, {1, 2}, {0, 1}}));
    }


}
