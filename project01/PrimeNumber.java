import java.util.Arrays;

public class PrimeNumber {

    // 使用埃拉托斯特尼筛法找出所有的素数
    public static boolean[] sieveOfEratosthenes(int max) {
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true); // 初始化数组，将所有数字标记为素数
        isPrime[0] = isPrime[1] = false; // 0 和 1 不是素数

        // 开始筛选
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false; // 将所有 i 的倍数标记为非素数
                }
            }
        }
        return isPrime;
    }

    public static void main(String[] args) {
        int limit = 20000;
        boolean[] isPrime = sieveOfEratosthenes(limit); // 获取 1 到 20000 之间的素数
        int count = 0;

        // 输出所有的素数，按每行 5 个格式打印
        for (int i = 1; i <= limit; i++) {
            if (isPrime[i]) {
                System.out.printf("%-6d", i); // 格式化输出每个素数，6字符宽度
                count++;

                // 每行打印 5 个素数
                if (count % 5 == 0) {
                    System.out.println(); // 换行
                }
            }
        }
    }
}
