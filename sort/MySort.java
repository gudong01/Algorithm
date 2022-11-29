package sort;

import java.util.Scanner;
//输入一个数组 完成排序

public class MySort {
    /**
     * 
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            int num = sc.nextInt();
            nums[i] = num;
        }
        sc.close();
        myQuickSort.quickSort(nums, 0, nums.length - 1);
    }

    // showNums
    public static void showNums(int[] nums) {
        for (int num : nums) {
            System.out.println(num);
        }
    }

}

class myQuickSort {
    // 升序
    public static void quickSort(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int pivotIndex = partition(nums, left, right);
        quickSort(nums, left, pivotIndex);
        quickSort(nums, pivotIndex + 1, right);

        
    }

    // 目的是获得基准元素的位置
    public static int partition(int[] nums, int left, int right) {
        int startIndex = left;
        int pivot = nums[left];
        while (left != right) {
            while (left < right && nums[left] < pivot) {
                left++;
            }
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            // 交换left 和 right元素
            if (left != right) {
                swap(nums, left, right);
            }
        }
        // 交换基准元素和相交点的元素
        swap(nums, startIndex, left);
        // 返回相交点
        return left;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}

