package easy;

import util.PrintUtil;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class 最小的K个数 {

    public static void main(String[] args) {
        PrintUtil.printArray(getLeastNumbers(new int[]{0,0,0,2,0,5}, 0));
    }
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k <= 0){
            return new int[]{};
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                queue.offer(arr[i]);
            } else if (arr[i] < queue.peek()) {
                queue.offer(arr[i]);
                queue.poll();
            }
        }
        return queue.stream().mapToInt(Integer::intValue).toArray();
    }
}
