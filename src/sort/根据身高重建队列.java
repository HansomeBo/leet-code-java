package sort;

import util.PrintUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/queue-reconstruction-by-height/
 * 找规律的题
 * 先对输入数组排序，h升序，k降序
 * 从头循环遍历 当前这个人就是剩下未安排的人中最矮的人，他的k值就代表他在剩余空位的索引值
 * 如果有多个人高度相同，要按照k值从大到小领取索引值 示例：
 * [ 0, 1, 2, 3, 4, 5 ] [ 4, 4 ] 4
 * [ 0, 1, 2, 3, 5 ]    [ 5, 2 ] 2
 * [ 0, 1, 3, 5 ]       [ 5, 0 ] 0
 * [ 1, 3, 5 ]          [ 6, 1 ] 3
 * [ 1, 5 ]             [ 7, 1 ] 5
 * [ 1 ]                [ 7, 0 ] 1
 * [ [ 5, 0 ], [ 7, 0 ], [ 5, 2 ], [ 6, 1 ], [ 4, 4 ], [ 7, 1 ] ]
 */
public class 根据身高重建队列 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        for (int i = 0; i < people.length; i++) {
            if (people[i][1] >= i) continue;/*当前节点满足重建队列后的条件*/
            int targetIndex = people[i][1];/*当前这个节点需要换到的位置*/
            /*冒泡方式把当前节点换到当前节点应该在的位置*/
            for (int j = i; j >= targetIndex + 1; j--) {
                swap(people, j);
            }
        }
        return people;
    }

    /**
     * 把当前节点向前移动一位
     * @param people
     * @param x
     */
    public void swap(int[][] people, int x) {
        int y = x - 1;
        int[] tmp = people[x];
        people[x] = people[y];
        people[y] = tmp;
    }

    public static void main(String[] args) {
        int[][] people = new 根据身高重建队列().reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        PrintUtil.printArray(people);
    }
}
