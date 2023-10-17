package linkedlist.recursion;

public class BinarySearch {

    static Integer binarySearch(int[] items, int start, int end, int num){
        if(start > end) return -1;
        int mid = (end + start) / 2;

        if(items[mid] == num) return mid;

        if(num < items[mid]){
            return binarySearch(items,start, mid - 1, num);
        }

        return binarySearch(items, mid + 1, end, num);
    }

    public static void main(String[] args){
        int[] nums = {1,3,4,5,6,7,8};
        System.out.println(binarySearch(nums, 0, nums.length - 1, 4));
    }
}
