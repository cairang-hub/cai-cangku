/**
 * 软件工程实验一 - 编程基本功练习(2)
 * 功能：找出一个整数数组中子数组之和的最大值（最大子数组和问题）
 * 算法：Kadane 算法（动态规划），时间复杂度 O(n)
 *
 * 测试样例：
 * 数组 [1, -2, 3, 5, -1]  返回 8（子数组 [3, 5]）
 * 数组 [1, -2, 3, -8, 5, 1] 返回 6（子数组 [5, 1]）
 * 数组 [1, -2, 3, -2, 5, 1] 返回 7（子数组 [3, -2, 5, 1]）
 *
 * @author cairang-hub
 */
public class MaxSubArray {

    /**
     * 计算整数数组中子数组之和的最大值
     *
     * @param array 整数数组
     * @return 子数组之和的最大值
     */
    public static int maxSubSum(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("数组不能为空");
        }
        // 当前子数组的最大和
        int currentSum = array[0];
        // 全局最大子数组和
        int maxSum = array[0];
        for (int i = 1; i < array.length; i++) {
            // 要么从当前元素重新开始，要么累加到前面的子数组上
            currentSum = Math.max(array[i], currentSum + array[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] array1 = {1, -2, 3, 5, -1};
        int[] array2 = {1, -2, 3, -8, 5, 1};
        int[] array3 = {1, -2, 3, -2, 5, 1};

        System.out.println("数组1的最大子数组和 = " + maxSubSum(array1));
        System.out.println("数组2的最大子数组和 = " + maxSubSum(array2));
        System.out.println("数组3的最大子数组和 = " + maxSubSum(array3));
    }
}
