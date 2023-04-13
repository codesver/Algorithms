package sorting;

public class QuickSorting extends Sorting {

    @Override
    void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    @Override
    void optimizedSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    int partition(int[] nums, int left, int right) {
        // For optimization change middle element(left + right / 2) with left element
        int pivot = nums[left];
        int i = left, j = right;
        while (i < j) {
            while (pivot < nums[j]) j--;
            while (i < j && pivot >= nums[i]) i++;
            swap(nums, i, j);
        }
        swap(nums, left, i);
        return i;
    }
}
