package sort;

import java.util.Random;

public class QuickSort{
    public static void main(String[] args) {
        QuickSort s = new QuickSort();
        int[] nums = new int[]{0,1,2,3,2,1,2,12,312,1};
        int n = nums.length;
        printArr(nums);
        s.quick_sort(nums,0,n-1);
        printArr(nums);
    }

    //快排入口
    public void quick_sort(int[] nums,int left,int right){
        if (left >= right) {
            return;
        }
        //获得基准值的坐标
        int pivotIndex = myPartition(nums, left, right);
        quick_sort(nums, left, pivotIndex);
        quick_sort(nums, pivotIndex+1, right);
    }

    //标准分割函数 获得基准点 处理大量重复数据快排不快
    public int myPartition(int[] nums,int left,int right){
        //随机获得基准值
        int pivotIndex = new Random().nextInt(right - left + 1) +left;
        swap(nums,pivotIndex,left);
        int pivot = nums[left];
        while(left != right){
            while(left <right && nums[right] >= pivot){
                right--;
            }
            nums[left] = nums[right];
            while(left < right && nums[left] <= pivot){
                left++;
            }
            nums[right] = nums[left];
        }
        //循环结束 把pivot放在相交点上 基准点
        //swap(nums, startIndex, left);
        nums[left] = pivot;
        return left;   
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void printArr(int[] nums){
        for(int x :nums){
            System.out.print(x + "\t");
        }
        System.out.println();
    }
}



