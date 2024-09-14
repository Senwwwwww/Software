public class ArraySum {
    public static int findMaxSubArraySum(int[] arr) {
        int maxCurrent = arr[0]; // 当前子数组的最大和
        int maxGlobal = arr[0];  // 全局最大子数组和

        for (int i = 1; i < arr.length; i++) {
            // 更新当前子数组的最大和
            maxCurrent = Math.max(arr[i], maxCurrent + arr[i]);
            // 更新全局最大子数组和
            if (maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
            }
        }

        return maxGlobal;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, -2, 3, 5, -1};
        int[] arr2 = {1, -2, 3, -8, 5, 1};
        int[] arr3 = {1, -2, 3, -2, 5, 1};

        System.out.println("最大子数组和 (数组1): " + findMaxSubArraySum(arr1)); // 输出 8
        System.out.println("最大子数组和 (数组2): " + findMaxSubArraySum(arr2)); // 输出 6
        System.out.println("最大子数组和 (数组3): " + findMaxSubArraySum(arr3)); // 输出 7
    }
}
