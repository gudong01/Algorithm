package sort;
public class MergeSort{
    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        int[] nums = new int[]{1,2,4,5,3,7,6,9,8,10};
        printArr(nums);
        m.merge_sort(nums);
        printArr(nums);
    }
    //归并排序入口
    public void merge_sort(int[] nums){
        int n = nums.length;
        int[] tempArr = new int[n];
        msort(nums, tempArr, 0, n-1);
    }

    public void msort(int[] nums, int[] tempArr, int left,int right){
        //两个以上的元素 划分
        if (left < right){
            int mid = (right - left)/2 + left;
            //拆分
            msort(nums, tempArr, left, mid);
            msort(nums, tempArr, mid+1, right);
            //合并
            merge(nums,tempArr,left,mid,right);
        }
    }

    public void merge(int[] nums, int[] tempArr,int left,int mid,int right){
        //合并已经排序的部分
        //标记左右半区未排序的第一个元素
        int l_pos = left, r_pos = mid+1,pos = left;
        while(l_pos <= mid && r_pos <= right){
            if(nums[l_pos] < nums[r_pos]){       //左半区更小
                tempArr[pos++] = nums[l_pos++]; 
            }else{                              //右半区更小
                tempArr[pos++] = nums[r_pos++];
            }
        }
        while(l_pos <= mid){
            tempArr[pos++] = nums[l_pos++];
        }
        while(r_pos <=right){
            tempArr[pos++] = nums[r_pos++];
        }

        //拷贝
        while(left <= right){
            nums[left] = tempArr[left];
            left++;
        }

    }

    public static void printArr(int[] nums){
        for(int x :nums){
            System.out.print(x + "\t");
        }
        System.out.println();
    }
}


