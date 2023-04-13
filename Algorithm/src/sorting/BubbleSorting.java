package sorting;

public class BubbleSorting extends Sorting {

    @Override
    public void sort(int[] nums) {
        for (int limit = nums.length - 1; limit > 0; limit--)
            for (int index = 0; index < limit; index++)
                if (nums[index] > nums[index + 1]) swap(nums, index, index + 1);
    }

    @Override
    void optimizedSort(int[] nums) {
        boolean swapped;
        for (int limit = nums.length - 1; limit > 0; limit--) {
            swapped = false;
            for (int index = 0; index < limit; index++) {
                if (nums[index] > nums[index + 1]) {
                    swap(nums, index, index + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
