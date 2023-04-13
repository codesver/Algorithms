package sorting;

public class InsertionSorting extends Sorting {

    @Override
    void sort(int[] nums) {
        for (int start = 1; start < nums.length; start++)
            for (int index = start; index > 0; index--)
                if (nums[index] < nums[index - 1]) swap(nums, index, index - 1);
                else break;
    }

    @Override
    void optimizedSort(int[] nums) {
        sort(nums);
    }
}
