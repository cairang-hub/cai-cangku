/**
 * 软件工程实验一 - 编程基本功练习(3)
 * 功能：输出 1~20000 内的所有素数，按每行 5 个打印
 *
 * 分析：
 * 1. 程序中最费时的函数是 isPrime() 素数判断函数。
 *    因为主循环要对 1~20000 的每个整数都调用一次 isPrime，
 *    而 isPrime 内部又需要循环试除，消耗大量 CPU 时间。
 *
 * 2. 改进方案：
 *    (1) 试除上限从 n 优化为 sqrt(n)（平方根），减少一半以上的循环次数。
 *        例如判断 20000 是否为素数，只需试除到 141 即可，无需试除到 20000。
 *    (2) 采用埃拉托斯特尼筛法（Sieve of Eratosthenes）：
 *        一次性从 2 开始标记所有合数，未被标记的就是素数，
 *        时间复杂度远低于对每个数单独试除。
 *    (3) 跳过所有偶数（除 2 以外），只判断奇数，可将试除次数再减半。
 *
 * @author cairang-hub
 */
public class Prime {

    /**
     * 判断一个整数是否为素数
     *
     * @param number 待判断的整数
     * @return 是素数返回 true，否则返回 false
     */
    public static boolean isPrime(int number) {
        // 小于等于 1 的数不是素数
        if (number <= 1) {
            return false;
        }
        // 2 是素数
        if (number == 2) {
            return true;
        }
        // 偶数（除 2 外）不是素数
        if (number % 2 == 0) {
            return false;
        }
        // 只需试除到平方根即可
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int count = 0;
        for (int num = 1; num <= 20000; num++) {
            if (isPrime(num)) {
                System.out.printf("%6d", num);
                count++;
                // 每行打印 5 个素数
                if (count % 5 == 0) {
                    System.out.println();
                }
            }
        }
        System.out.println();
    }
}
