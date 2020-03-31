package SortAlgorithm;

public class HeapSort {
    public int[] sort(int[] nums) {
        int max_index = nums.length-1;
        int begin_index = max_index>>1;

        for(int i = begin_index; i >= 0; i--){
            maxHeapify(nums,i,max_index);
        }
        for(int i = max_index; i > 0; i--){
            swap(nums,0,i);
            maxHeapify(nums,0,i-1);
        }
        return nums;
    }

    private static void swap(int nums[], int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private static void maxHeapify(int nums[], int index, int max_index){
        int left = (index << 1)+1;
        int right = left+1;
        //下面注释的代码会引发错误。因为left==max_index时，可能不存在右子结点，此时不能直接返回，而应将当前结点与左子结点进行比较
//        if(left>=max_index)
//            return;
//        int biiger_index = nums[left]>nums[right]?left:right;
        if(left > max_index){
            return;
        }
        int bigger_index = left;
        if(right <= max_index&&nums[right]>nums[left])
            bigger_index = right;
        if(nums[index] < nums[bigger_index]){
            swap(nums,index,bigger_index);
            maxHeapify(nums,bigger_index,max_index);
        }
    }

}
