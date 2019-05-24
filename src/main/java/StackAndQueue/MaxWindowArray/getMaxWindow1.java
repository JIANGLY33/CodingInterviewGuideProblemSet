package StackAndQueue.MaxWindowArray;

/** 常规解法：迭代数组,时间复杂度为O(N*W)
 */
public class getMaxWindow1 {
   public static int[] getMaxWindow(int[] array, int w) {
       int[] result = new int[array.length-w+1];
       for(int i = 0; i < array.length-w+1; i++) {
            int max = array[i];
            for(int j = i+1; j < i+w; j++) {
                if(array[j] > max)max = array[j];
            }
            result[i] = max;
       }
       return result;
   }

    public static void main(String[] args) {
        for(int x :getMaxWindow1.getMaxWindow(new int[]{4,3,5,4,3,3,6,7,4,3,2,6,7,8,9},3)) {
            System.out.print(x + " ");
        }
    }
}
