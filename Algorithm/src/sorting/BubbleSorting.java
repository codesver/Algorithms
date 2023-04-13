package sorting;

public class BubbleSorting extends Sorting {

    @Override
    public void sort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--)
            for (int j = 0; j < i; j++)
                if (nums[j] > nums[j + 1]) swap(nums, j, j + 1);
    }

    @Override
    void optimizedSort(int[] nums) {
        boolean swapped;
        for (int i = nums.length - 1; i > 0; i--) {
            swapped = false;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
